/**
 * 此类用来测试定位消耗CPU做多的线程的测试例子
 * Created by zcd on 2018/4/24.
 */
public class Entrance {
    public static void main(String[] args) {
        for (int i = 0; i < 10 ; i++) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(100000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
        Thread t = new Thread(){
            @Override
            public void run() {
                int i=0;
                while (true){
                    i = (i++)/100;
                }
            }
        };
        t.setName("Business Thread");
        t.start();
    }
}
