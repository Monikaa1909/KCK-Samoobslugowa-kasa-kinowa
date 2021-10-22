

import java.util.Date;

public class Bilet {
    public static Date data;
    public static void podaj(Date wybrana_data){
        data = wybrana_data;
        System.out.println(data.toString());
    }
}
