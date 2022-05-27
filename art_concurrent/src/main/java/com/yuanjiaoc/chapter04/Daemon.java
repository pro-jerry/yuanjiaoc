package com.yuanjiaoc.chapter04;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年05月27日
 */
public class Daemon {

  public static void main(String[] args) {
      Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
      thread.setDaemon(true);
      thread.start();
  }

    static class DaemonRunner implements Runnable{

        @Override
        public void run() {
            try{
                SleepUtils.second(10);
            }finally{
                System.out.println("DaemonThread finally run.");
            }

        }
    }
}
