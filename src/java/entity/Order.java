package entity;

import java.util.List;

/**
 *
 * @author Jamie
 */
public class Order {
    
    private User user;
    private List<Orderline> cList;
    private int total;

    public Order(User user, List<Orderline> cList) {
        this.user = user;
        this.cList = cList;
        this.total=cList.get(0).getPrice();
    }
    
    public void addCupcake(Orderline ol){
        cList.add(ol);
        total+=ol.getPrice();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Orderline> getcList() {
        return cList;
    }

    public void setcList(List<Orderline> cList) {
        this.cList = cList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
}
