package teamprojects.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.home.teamprojects.dataAnalyser;

class tests {

	
	@ParameterizedTest
	@ValueSource(strings = {"2343225,2345,us_east,RedTeam,ProjectApple,3445s"})
	void test_single_line_input_unique_customer_for_contract(String input) {
		dataAnalyser dataAnalyserObject = new dataAnalyser();
		String[] lines = {input};
		Integer contractIdFromTestData =  2345;
		boolean init_result  = dataAnalyserObject.init(lines);
		assertTrue(init_result, "input is incorrect");
		
		Integer actualUniqueCustomerIds = dataAnalyserObject.GetContractsUniqueCustomerCounts(contractIdFromTestData);
		Integer expectedUniqueCustomerIds = 1;
		assertEquals(expectedUniqueCustomerIds, actualUniqueCustomerIds, "Assert Equals - Uniques Customer Id for contract failed");
		
	}
	@ParameterizedTest
	@ValueSource(strings = {"2343225,2345,us_east,RedTeam,ProjectApple,3445s"})
	void test_single_line_input_unique_customer_for_geozone(String input) {
		dataAnalyser dataAnalyserObject = new dataAnalyser();
		String[] lines = {input};
		String geozoneIdFromTestData =  "us_east";
		boolean init_result  = dataAnalyserObject.init(lines);
		assertTrue(init_result, "input is incorrect");
		
		Integer actualUniqueCustomerIds = dataAnalyserObject.getGeozoneUniqueCustomerIds(geozoneIdFromTestData);
		Integer expectedUniqueCustomerIds = 1;
		assertEquals(expectedUniqueCustomerIds, actualUniqueCustomerIds, "Assert Equals - Uniques Customer Id for geozone failed");
		
	}
	@ParameterizedTest
	@ValueSource(strings = {"2343225,2345,us_east,RedTeam,ProjectApple,3445s"})
	void test_single_line_input_avg_build_time_for_geozone(String input) {
		dataAnalyser dataAnalyserObject = new dataAnalyser();
		String[] lines = {input};
		String geozoneIdFromTestData =  "us_east";
		boolean init_result  = dataAnalyserObject.init(lines);
		assertTrue(init_result, "input is incorrect");
		
		double actualAvgBuildTime = dataAnalyserObject.getGeozoneAverageBuildTime(geozoneIdFromTestData);
		double  expectedAvgBuildTime = 3445;
		assertEquals(actualAvgBuildTime, expectedAvgBuildTime, "Assert Equals - Avg Build Time for geozone failed");
		
	}
	///two line
	@ParameterizedTest
	@ValueSource(strings = {"2343225,2345,us_east,RedTeam,ProjectApple,3445s\n"
			+ "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s"})
	void test_two_line_input_unique_customer_for_contract(String input) {
		dataAnalyser dataAnalyserObject = new dataAnalyser();
		String[] lines = input.split("\\r?\\n");// new ArrayList<String>();
		
		//lines.add(input);
		Integer contractIdFromTestData =  2345;
		boolean init_result  = dataAnalyserObject.init(lines);
		assertTrue(init_result, "input is incorrect");
		
		Integer actualUniqueCustomerIds = dataAnalyserObject.GetContractsUniqueCustomerCounts(contractIdFromTestData);
		Integer expectedUniqueCustomerIds = 2;
		assertEquals(expectedUniqueCustomerIds, actualUniqueCustomerIds, "Assert Equals - Uniques Customer Id for contract failed");
		
	}
	@ParameterizedTest
	@ValueSource(strings = {"2343225,2345,us_east,RedTeam,ProjectApple,3445s\n"
			+ "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s"})
	void test_two_line_input_unique_customer_for_geozone(String input) {
		dataAnalyser dataAnalyserObject = new dataAnalyser();
		String[] lines = input.split("\\r?\\n");// new ArrayList<String>();
		//lines.add(input);
		String geozoneIdFromTestData =  "us_east";
		boolean init_result  = dataAnalyserObject.init(lines);
		assertTrue(init_result, "input is incorrect");
		
		Integer actualUniqueCustomerIds = dataAnalyserObject.getGeozoneUniqueCustomerIds(geozoneIdFromTestData);
		Integer expectedUniqueCustomerIds = 1;
		assertEquals(expectedUniqueCustomerIds, actualUniqueCustomerIds, "Assert Equals - Uniques Customer Id for geozone failed");
		
	}
	@ParameterizedTest
	@ValueSource(strings = {"2343225,2345,us_east,RedTeam,ProjectApple,3445s\n"
			+ "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s"})
	void test_two_line_input_avg_build_time_for_geozone(String input) {
		
		dataAnalyser dataAnalyserObject = new dataAnalyser();
		String[] lines = input.split("\\r?\\n");// new ArrayList<String>();
		
		String geozoneIdFromTestData =  "us_east";
		boolean init_result  = dataAnalyserObject.init(lines);
		assertTrue(init_result, "input is incorrect");
		
		double actualAvgBuildTime = dataAnalyserObject.getGeozoneAverageBuildTime(geozoneIdFromTestData);
		double  expectedAvgBuildTime = 3445;
		assertEquals(actualAvgBuildTime, expectedAvgBuildTime, "Assert Equals - Avg Build Time for geozone failed");
		
	}
	///
	///multi line
		@ParameterizedTest
		@ValueSource(strings = {"2343225,2345,us_east,RedTeam,ProjectApple,3445s\n"
				+ "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n"
				+ "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\n"
				+ "1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n"
				+ "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s"})
		void test_multi_line_input_unique_customer_for_contract(String input) {
			dataAnalyser dataAnalyserObject = new dataAnalyser();
			String[] lines = input.split("\\r?\\n");// new ArrayList<String>();
			
			//lines.add(input);
			Integer contractIdFromTestData =  2345;
			boolean init_result  = dataAnalyserObject.init(lines);
			assertTrue(init_result, "input is incorrect");
			
			Integer actualUniqueCustomerIds = dataAnalyserObject.GetContractsUniqueCustomerCounts(contractIdFromTestData);
			Integer expectedUniqueCustomerIds = 3;
			assertEquals(expectedUniqueCustomerIds, actualUniqueCustomerIds, "Assert Equals - Uniques Customer Id for contract failed");
			
		}
		@ParameterizedTest
		@ValueSource(strings = {"2343225,2345,us_east,RedTeam,ProjectApple,3445s\n"
				+ "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n"
				+ "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\n"
				+ "1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n"
				+ "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s"})
		void test_multi_line_input_unique_customer_for_geozone(String input) {
			dataAnalyser dataAnalyserObject = new dataAnalyser();
			String[] lines = input.split("\\r?\\n");// new ArrayList<String>();
			//lines.add(input);
			String geozoneIdFromTestData =  "us_west";
			boolean init_result  = dataAnalyserObject.init(lines);
			assertTrue(init_result, "input is incorrect");
			
			Integer actualUniqueCustomerIds = dataAnalyserObject.getGeozoneUniqueCustomerIds(geozoneIdFromTestData);
			Integer expectedUniqueCustomerIds = 2;
			assertEquals(expectedUniqueCustomerIds, actualUniqueCustomerIds, "Assert Equals - Uniques Customer Id for geozone failed");
			
		}
		@ParameterizedTest
		@ValueSource(strings = {"2343225,2345,us_east,RedTeam,ProjectApple,3445s\n"
				+ "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n"
				+ "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\n"
				+ "1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n"
				+ "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s"})
		void test_multi_line_input_avg_build_time_for_geozone(String input) {
			
			dataAnalyser dataAnalyserObject = new dataAnalyser();
			String[] lines = input.split("\\r?\\n");// new ArrayList<String>();
			
			String geozoneIdFromTestData =  "eu_west";
			boolean init_result  = dataAnalyserObject.init(lines);
			assertTrue(init_result, "input is incorrect");
			
			double actualAvgBuildTime = dataAnalyserObject.getGeozoneAverageBuildTime(geozoneIdFromTestData);
			double  expectedAvgBuildTime = 4222;
			assertEquals(actualAvgBuildTime, expectedAvgBuildTime, "Assert Equals - Avg Build Time for geozone failed");
			
		}
		///

}

