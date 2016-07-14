package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import cn.org.rapid_framework.generator.GeneratorFacade;

public class GenCodeUtil {

	public static void todo(List<Properties> list, String tablename,
			String temprootpath) throws Exception {

		File input = new File("src/start.xml");
		// 即将生成的文件
		File output = new File("src/generator.xml");

		FileInputStream in = new FileInputStream(input);
		FileOutputStream out = new FileOutputStream(output);

		int c;
		while ((c = in.read()) != -1) {
			out.write(c);
		}

		// XXX 插入要生成的代码片段

		for (Properties p : list) {
			out.write(("	<entry key=\"" + p.getKey() + "\">" + p.getValue() + "</entry>\r\n")
					.getBytes());
		}

		// 填补最后一个标签
		String a = "</properties>";
		out.write(a.getBytes());
		// 关闭留
		in.close();
		out.close();

		// 运行
		GeneratorFacade g = new GeneratorFacade();
		// 删除生成器的输出目录//
		g.deleteOutRootDir();

		g.generateByTable(tablename, temprootpath);
	}

}
