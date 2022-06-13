package com.jf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BizShowPropertyTest {

    public static void main(String[] args) throws IOException {
        String sql = "update biz_show_property set is_deleted = 1 where is_deleted = 0 and biz_show_id in ('6034a40d99012d61b2677590')  \n" +
                "and id not in (select temp.id from (select min(id) as id from biz_show_property \n" +
                "where is_deleted = 0 and biz_show_id in ('6034a40d99012d61b2677590')\n" +
                "group by parent_module_key,module_key) as temp); ";

        int index = 0;
        File file = new File("C:\\Users\\MTL\\Desktop\\biz_show_property重复的节目ID.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String string = null;
        StringBuffer sb = new StringBuffer();
        while ((string = br.readLine()) != null) {
            String trim = string.trim();
            String replace = sql.replace("6034a40d99012d61b2677590", trim);
            System.out.println(replace);
            System.out.println();
            System.out.println();
        }
        br.close();

    }

}

