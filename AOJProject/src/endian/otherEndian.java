package endian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class otherEndian {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt =Integer.parseInt(br.readLine());

        while (cnt-- > 0) {
            Long a = Long.valueOf(br.readLine());

            System.out.println(((a & 0x000000ffl) << 24) | ((a & 0x0000ff00l) << 8)
                    | ((a & 0x00ff0000l) >> 8) | ((a & 0xff000000l) >> 24));
        }
    }

}
