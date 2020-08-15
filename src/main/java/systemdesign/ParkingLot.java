package systemdesign;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

// singleton
public class ParkingLot {

    private int activeVehicles; // 停车场内存在的车有多少
    private HashMap<String, Date> vehiclesIn = new HashMap<>(); // 维护一个"车牌号-车进场时间"的KV对
    private HashMap<String, Date> vehiclesOut = new HashMap<>(); // "车牌号-车出场时间"

    private HashMap<String, EntranceDevice> entranceDevice;
    private HashMap<String, ExitDevice> exitDevice;
    private int capacity;

    private static ParkingLot parkingLot = null;

    // private constructor to restrict for singleton
    private ParkingLot() {
        capacity = 30; // 30个空位
        // 2个入口
        entranceDevice.put("1-ent", new EntranceDevice(this));
        entranceDevice.put("2-ent", new EntranceDevice(this));
        // 2个出口
        exitDevice.put("1-exi", new ExitDevice(this));
        exitDevice.put("2-exi", new ExitDevice(this));
    }

    // static method to get the singleton instance of ParkingLot
    public static ParkingLot getInstance() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    public boolean isFull() {
        activeVehicles = vehiclesIn.size(); // 或者 vehiclesOut.size()
        return activeVehicles >= capacity;
    }

    // synchronized: 因为可能两辆车同时进场，用synchronized确保线程安全
    public synchronized String getNewParkingVehicle(Vehicle vehicle) throws ParkingFullException, ParseException {
        if (this.isFull()) {
            throw new ParkingFullException();
        }
        String vehicleNumber = vehicle.getPlateNumber();
        vehicle.assignNumber(vehicleNumber);

        // vehicleNumber.saveInDB(); 存入数据库，这个方法这里不写
        // 如果成功存入，存入vehiclesIn数组，activeVehicles++
        this.vehiclesIn.put(vehicleNumber, entranceDevice.get(1).getTime1()); // get(1): 假设从第一个entrance进入
        this.activeVehicles++;
        return vehicleNumber;
    }

    public HashMap<String, Date> getVehiclesIn() {
        return vehiclesIn;
    }

    public HashMap<String, Date> getVehiclesOut() {
        return vehiclesOut;
    }

}


class ParkingRate {
    private static double amount = 0;
    private ParkingLot parkingLot;

    public double getRate(double parkingHour) { // 假设是这样计费的
        if(parkingHour <= 2){
            amount = 4.5;
        } else if (parkingHour > 2 && parkingHour <= 24) {
            amount = 5 + 3 * (parkingHour - 2);
        } else {
            amount = 7 * (parkingHour/24);
        }
        return amount;
    }
}

class EntranceDevice {
    private Camera camera; // 用于拍摄当前车牌号的设备
    private SimpleDateFormat time1; // 当前车进场时间, 后面转化为Date类型

    private ParkingLot parkingLot; // 是哪个停车场的entrance设备

    public EntranceDevice(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public String getPlate() {
        return camera.scan();
    }

    public Date getTime1() throws ParseException {
        return time1.parse(time1.toString());
    }
}

class ExitDevice {
    private static Camera camera; // 拍照
    private SimpleDateFormat time2; // 当前车出场时间

    private ParkingLot parkingLot; // 是哪个停车场的entrance设备
    private ParkingRate parkingRate; // 计算费用

    private double parkingHour = (parkingLot.getVehiclesOut().get(getPlate()).getTime()
            - parkingLot.getVehiclesIn().get(getPlate()).getTime())/(24*60*60*1000);

    public ExitDevice(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public static String getPlate() {
        return camera.scan();
    }
    public Date getTime2() throws ParseException {
        return time2.parse(time2.toString());
    }

    public double getParkingRate(String plate) {
        return parkingRate.getRate(parkingHour);
    }
}

class Camera {
    // IoT: scan the plate of this vehicle. Irrelevant to ParkingLot system.
    public static String scan() {
        // 用某种方式拍摄当前车牌号, 这里只是简单的返回固定的某个String
        return "京N 00321";
    }
}

class Vehicle {
    // 暂时不考虑其他的性质
    private String plateNumber;

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void assignNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}

class ParkingFullException extends Throwable {
    private static ParkingLot parkingLot;

    public static void full() throws Exception {
        if (parkingLot.isFull()) {
            throw new Exception("Parking lot is full !");
        }
    }
}

