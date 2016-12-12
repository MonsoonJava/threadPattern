package cn.xfj.producerandconsumer;

public class Table {

    private final String[] data;
    
    private int count = 0;//记录有多少的数据存储量
    
    private int tail = 0;//下一个存储数据的位置
    
    private int head = 0;//下一个取数据的位置
    
    public Table(int dataNumber){
        data = new String[dataNumber];
    }
    
    public synchronized void put(String cake) throws InterruptedException{
        while( count >= data.length){
            this.wait();
        }
        data[tail] = cake;
        tail = (tail + 1) % data.length;
        count++;
        System.out.println(cake);
        this.notifyAll();
    }
    
    public synchronized String take() throws InterruptedException{
        while(count <= 0){
            this.wait();
        }
        String cake = data[head];
        head = (head + 1) % data.length;
        count--;
        String showStatements = Thread.currentThread().getName() + " consume the " + 
                cake.substring(cake.indexOf("the") + 3);
        System.out.println(showStatements);
        this.notifyAll();
        return cake;
    }
    
    public synchronized void clear(){
        while(count <= 0){
            count = 0;
            head = 0;
            tail = 0;
            return;
        }
        for(int i=0;i<data.length;i++){
            data[i] = null;
        }
        count = 0;
        head = 0;
        tail = 0;
    }
}
