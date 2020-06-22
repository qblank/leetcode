package study.designmode.observer1;

import java.util.ArrayList;
import java.util.List;

/**
 * 通知者接口
 * @version 1.0
 * @date 2019/1/21 21:57
 */
public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void detach(Observer observer){
        observers.remove(observer);
    }

    public void notifyIt(){
        for(Observer observer : observers){
            observer.update();
        }
    }
}
