import java.lang.*;

class ThreadSample {
  public static void main(String[] args) {
//névtelek függvény, lambda függvény
    Thread t = new Thread(() -> {
      for(int i = 0; i<10; ++i){
        System.out.println("One " + i);
      }
    });
  //t.run() //rossz, mert a run a névtelen függvény képessége
  //nem készít szálat, nincs új száll, emrt ez a runable-nek a run-ja , nem pedig a threadhez kapcsolódik
  //vannak prioritások, de a rendszer tudja mit kell csinálni

  t.start(); //
  Runnable r = () -> {
      for(int i = 10; i<20; ++i){
        System.out.println("Other " + i);
      }
    };
  Thread t2 = new Thread(r);

  t2.start();
//interleaved, összefésült kiírás 
//két szál egymástól teljesen függetlenül működik
//egymagos rendszeren is lehet futtatni, egy száll kódját futtatj
//daemon számok nem számítanak bele a szálak közé
//start()-al kezdődik el az új száll

  }
}