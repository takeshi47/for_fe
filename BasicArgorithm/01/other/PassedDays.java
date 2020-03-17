/**
 * 生年月日から入力された日付までの経由日数と
 * 生年月日の曜日を表示する
 * 2020/01/23
 */
public class PassedDays {
	/**
	* [getPassedDays description]
	* @param year      [description]
	* @param month     [description]
	* @param day       [description]
	* @param thisYear  [description]
	* @param thisMonth [description]
	* @param today     [description]
	* @param weekly    [description]
	*/
	public static void getPassedDays(int year , int month, int day, int thisYear, int thisMonth, int today, int weekly) {
		int passedDays = 0;
		int d = 0;
		int y = 0;
		int week;
		//通常年の1~12月の日数を格納した配列
		int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		//うるう年の1~12月の
		int[] days2 = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		int uruu = 0;

		//生まれた年の翌年から昨年までの経過日数
		for (int i = year + 1; i < thisYear; i++) {
			if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
				d += 366;
				uruu ++;
			} else {
				d += 365;
			}
		}
		// //生まれた日からその年末までの経過日数
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			uruu ++;
			for (int i = month; i < 12; i++) {
				d += days2[i];
			}
			d += (days2[month - 1] - day);
		} else {
			for (int i = month; i < 12; i++) {
				d += days[i];
			}
			d += (days[month - 1] - day);
		}
		// 今年の経過年数
		d += today;
		if (thisYear % 4 == 0 && thisYear % 100 != 0 || thisYear % 400 == 0) {
			for (int i = 0; i < thisMonth - 1 ; i++ ) {
				d += days2[i];
			}
			uruu ++;
		} else {
			for (int i = 0; i < thisMonth - 1; i++) {
				d += days[i];
			}
		}
		System.out.printf("誕生日:%d/%02d/%02d", year, month, day);
		System.out.println();
		System.out.printf("現在の日付:%d/%02d/%02d", thisYear, thisMonth, today);
		System.out.println();
		System.out.println("経過日数:" + d + "\nその間のうるう年の数:" + uruu);

		//誕生日の曜日を調べる
		week = weekly - d % 7;
		if (week < 0) week += 7;
		switch (week) {
		case 0:
			System.out.println("誕生日は日曜日");
			break;
		case 1:
			System.out.println("誕生日は月曜日");
			break;
		case 2:
			System.out.println("誕生日は火曜日");
			break;
		case 3:
			System.out.println("誕生日は水曜日");
			break;
		case 4:
			System.out.println("誕生日は木曜日");
			break;
		case 5:
			System.out.println("誕生日は金曜日");
			break;
		case 6:
			System.out.println("誕生日は土曜日");
			break;
		default:
			break;
		}
	}
	/**
	 * main
	 */
	public static void main(String[] args) {
		getPassedDays(1989, 7, 9, 2020, 1, 22, 3);
	}
}