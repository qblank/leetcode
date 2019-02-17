package study.designmode.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version 1.0
 * @date 2019/2/17 10:18
 */
public class WebsiteFactory {
    private Map<String,Object> flyweights = new ConcurrentHashMap<>();

    /**
     * 获取网站分类
     * @param key
     * @return
     */
    public Website getWebsiteCategory(String key){
        if (!flyweights.containsKey(key)){
            flyweights.put(key,new ConcreateWebsite(key));
        }
        return (Website) flyweights.get(key);
    }

    /**
     * 获取网站总数
     * @return
     */
    public int getWebsiteCount(){
        return flyweights.size();
    }
}
