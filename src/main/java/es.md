### ELK

1. elasticsearch/solr : json文本搜索引擎
2. logstash: linux日志收集(外:web服务器日志)插件
3. kibana: elasticsearch的web控制台
4. 流程: web服务器->logstash->es->kibana

存储金字塔:
1. CPU，一级二级缓存
2. DRAM
3. 持久层

搜索类型:
1. 过滤型/KV(redis); e.g. jd: 1级2级3级分类 (where id=xx)
2. 文本型/关键字: es; (where xx like yy) (倒排索引)

