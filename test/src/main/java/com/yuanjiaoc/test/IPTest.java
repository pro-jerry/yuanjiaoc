package com.yuanjiaoc.test;

import cn.hutool.core.net.Ipv4Util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

/**
 * 根据IP地址/子网掩码生成IP地址.
 *
 * @author 何二白
 * @version 1.0
 * @see <a href="https://blog.csdn.net/qq_41936784/article/details/121371597"></a>
 * @since 2022年09月29日
 */
public class IPTest {

    public static void main(String[] args) throws FileNotFoundException {

        String ipStr = "1.202.162.0/25,120.92.67.0/26";
        String[] ipArrList = ipStr.split(",");
        for (String str : ipArrList) {
            String ip = str.split("/")[0];
            int mask = Integer.parseInt(str.split("/")[1]);
            String ipFrom = Ipv4Util.getBeginIpStr(ip, mask);
            String ipTo = Ipv4Util.getEndIpStr(ip, mask);
            List<String> ipList = Ipv4Util.list(ipFrom, ipTo);
            System.out.println(ipList);
        }

        String ipSegLine =
                "1.202.162.0/25\n"
                        + "120.92.67.0/26\n"
                        + "106.37.187.128/25\n"
                        + "114.247.175.192/26\n"
                        + "223.71.7.192/27\n"
                        + "36.110.204.128/26 \n"
                        + "111.202.86.128/26 \n"
                        + "39.155.195.64/26 \n"
                        + "120.92.24.128/26\n";

        PrintWriter printWriter =
                new PrintWriter(new File(System.getProperty("user.home"), "/Desktop/xiaomiIp.txt"));
        Scanner scanner = new Scanner(ipSegLine);
        while (scanner.hasNextLine()) {
            String ln = scanner.nextLine();
//            List<String> list = IpUtil.getIpsV4ByCidr(ln.trim());
//            System.out.println(list.size());
//            list.forEach(printWriter::println);
        }
        scanner.close();
        printWriter.flush();
        printWriter.close();

    }
}
