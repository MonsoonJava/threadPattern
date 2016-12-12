package cn.xfj.mythread;

public class Gate {
    private  String name ;
    private  String address;
    private  int count = 0; 
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private void addCount(){
        this.count++;
    }
    
    private void check(){
        if(name.charAt(0) != address.charAt(0)){
            System.out.println(count +"   ERROR in thread    " + name +"     " + address);
        }
    }
    
    public synchronized void pass(String name,String address){
        this.name = name;
        this.address = address;
        this.addCount();
        this.check();
    }
}
