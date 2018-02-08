package org.robert0714.ods2018;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import com.github.jferard.fastods.AnonymousOdsFileWriter;
import com.github.jferard.fastods.OdsDocument;
import com.github.jferard.fastods.OdsFactory;
import com.github.jferard.fastods.Table;
import com.github.jferard.fastods.TableCellWalker;
import com.github.jferard.fastods.TableRow;
import com.github.jferard.fastods.style.TableCellStyle;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;

public class Service01 {
	public void demo01() throws IOException {
		final OdsFactory odsFactory = OdsFactory.create(Logger.getLogger("example"), Locale.getDefault());
		final AnonymousOdsFileWriter writer = odsFactory.createWriter();
		final OdsDocument document = writer.document();
		final Table table = document.addTable("test");

		final TableCellStyle style = TableCellStyle.builder("green cell style").backgroundColor("#00FF00").build();
		for (int y = 0; y < 50; y++) {
			final TableRow row = table.nextRow();
			final TableCellWalker cell = row.getWalker();
			for (int x = 0; x < 5; x++) {
				cell.setFloatValue(x * y);
				cell.setStyle(style);
				cell.next();
			}
		}
		File output = new File(FileUtils.getTempDirectory(), "readme_example.ods");
		System.out.println(output.getAbsolutePath());
		writer.saveAs(output);
	}
}
