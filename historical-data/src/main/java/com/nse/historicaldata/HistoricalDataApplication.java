package com.nse.historicaldata;

import java.util.Arrays;
import java.util.List;

import com.nse.historicaldata.constants.ConsumerConstants;
import com.nse.historicaldata.dto.QueryDateDto;
import com.nse.historicaldata.dto.QueryDateDto.CalenderPeriod;
import com.nse.historicaldata.utils.NSEFileUtils;

public class HistoricalDataApplication {

	public static void main(String[] args) {
		List<QueryDateDto> queryDates = QueryDateDto.prepareQueryDates(3, CalenderPeriod.YEARS);
		for (String ipo : NSEFileUtils.readFromFilePutContentToList("", Arrays.asList("ipoNames.txt"), null,
				ConsumerConstants.GENERIC_FILE_EXIT_OPERATION)) {
			System.out.println(ipo.toUpperCase());
			NSEFileUtils.readFromAndWriteToFile(ipo.toUpperCase(),
					ConsumerConstants.BUILD_DTO_FROM_INPUT_FILE_WRITE_TO_OUTPUT_FILE,
					ConsumerConstants.FILE_EXIT_OPERATION, queryDates);
		}

	}

}