package kz.ugs.callisto.mis.loaders.sheet;

import java.util.List;
import kz.ugs.callisto.mis.loaders.sheet.model.Indicator;
import kz.ugs.callisto.mis.loaders.sheet.reader.Reader;


/**
 * @author ZTokbayev
 *
 */
public class App	{
	
    public static void main( String[] args )	{
        Reader reader = new Reader("c:/developerenv/temp/показатели анализа крови.xlsx");
        List <Indicator> list = reader.getIndicatorsFromExcel();
        for (Indicator indicator : list) {
			System.out.println(indicator.getName());
		}
    }
}
