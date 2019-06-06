package test.mysql.binlog;

import com.alibaba.fastjson.JSON;
import com.github.shyiko.mysql.binlog.BinaryLogFileReader;
import com.github.shyiko.mysql.binlog.event.Event;
import com.github.shyiko.mysql.binlog.event.TableMapEventData;
import com.github.shyiko.mysql.binlog.event.WriteRowsEventData;
import com.github.shyiko.mysql.binlog.event.deserialization.ChecksumType;
import com.github.shyiko.mysql.binlog.event.deserialization.EventDeserializer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BakBinLog {
	public static void main(String[] args) throws IOException {
		String filePath = "C:\\Users\\panda\\Desktop\\mysql-bin.000005";
		File binlogFile = new File(filePath);
		EventDeserializer eventDeserializer = new EventDeserializer();
		eventDeserializer.setChecksumType(ChecksumType.CRC32);
		BinaryLogFileReader reader = new BinaryLogFileReader(binlogFile, eventDeserializer);
		try {
			// 准备写入的文件名称
			/*
			 * File f1 = new File("D:\\mysql-bin.000845.sql"); if
			 * (f1.exists()==false){ f1.getParentFile().mkdirs(); }
			 */
			FileOutputStream fos = new FileOutputStream("C:/Users/panda/Desktop/bak001.sql", true);
			
			String db = "imkefu_v2";
			String tb = "chat_message";
			String sql = "INSERT INTO chat_message(`id`, `from_user`, `to_user`, `create_time`, `content`, `type`, `session_id`) VALUES" ; 
					
			for (Event event; (event = reader.readEvent()) != null;) {
			    Object d = event.getData();
			    
				if (d instanceof TableMapEventData) {
					//获取数据库和表名
					TableMapEventData tdata = (TableMapEventData)d;
				    String db2 = tdata.getDatabase();
				    String tb2 = tdata.getTable();
				    if (db.equals(db2) && tb.equals(tb2)) {
				    	
				    } else continue;
					
				} else if (d instanceof WriteRowsEventData) {
					//获取记录
		    	   WriteRowsEventData data = (WriteRowsEventData)d;
		    	   List list = Arrays.asList(data.getRows().get(0));
		    	   
		    	   
		    	   String ser = JSON.toJSONString(list);
		    	   ser = ser.replace("[", "").replace("]", "");
		    	   ser = sql+"("+ser+");";
		    		System.out.println(ser);
		    		 
					// 把数据写入到输出流
					//fos.write(ser.getBytes());
					
				}
			
			}
			// 关闭输出流
			fos.close();
			System.out.println("输入完成");
		} finally {
			reader.close();
		}
 
	}

}
