package study.designmode.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @date 2019/1/31 17:05
 */
public class ConcreateCompany extends Company {
    private List<Company> children = new ArrayList<>();

    public ConcreateCompany(String name) {
        super(name);
    }


    @Override
    public void add(Company c) {
        children.add(c);
    }

    @Override
    public void remove(Company c) {
        children.remove(c);
    }

    @Override
    public void display(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("-");
        }
        System.out.println(name);
        for(Company company:children){
            company.display(depth + 2);
        }
    }

    @Override
    public void lineOfDuty() {

    }
}
