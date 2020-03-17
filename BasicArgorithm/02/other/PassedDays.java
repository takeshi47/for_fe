/**
 * 生年月日から入力された日付までの経過日数と
 * 生年月日の曜日を表示する
 * 2020/02/14
 */
public class PassedDays {

	public static void getPassedDays(int birthYear, int birthMonth, int birthDay, int thisYear, int thisMonth, int today, int weekly) {

		int d = 0;
		int y = 0;
		//通常年の各月の日数を格納した配列
		int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		//閏年の各月の日数を格納した配列
		int[] uruuDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		//生まれた日からその年末までの日数
		if (uruu(birthYear)) {  //生まれた年が閏年の時
			//生まれた月の翌月から年末までの日数を加算
			for (int i = birthMonth; i < uruuDays.length; i++) {
				d += uruuDays[i];
			}
			//生まれた月の残り日数を加算
			d += (uruuDays[birthMonth - 1] - birthDay);
		} else {                //生まれた年がうるう年ではない時
			for (int i = birthMonth; i < days.length; i++) {
				d += days[i];
			}
			d += (days[birthMonth - 1] - birthDay);
		}

		//生まれた年の翌年から昨年までの経過日数
		for (int i = birthYear + 1; i < thisYear; i++) {
			if (uruu(i)) {
				d += 366;
			} else {
				d += 365;
			}
		}

		//本年の経過日数
		d += today;
		if (uruu(thisYear)) {
			for (int i = 0; i < thisMonth - 1; i++) {
				d += uruuDays[i];
			}
		} else {
			for (int i = 0; i < thisMonth - 1; i++) {
				d += days[i];
			}
		}

		System.out.printf("誕生日:%d/%02d/%02d", birthYear, birthMonth, birthDay);
		System.out.println();
		System.out.printf("現在の日付:%d/%02d/%02d\n", thisYear, thisMonth, today);
		System.out.println("経過日数:" + d);

		weekly(weekly, d);
	}
	/**
	 * [uruu description]
	* うるう年かどうかを判定する。
	 * @param  year [description]
	 * @return      [description]
	 */
	public static boolean uruu(int year) {

		boolean flg = false;

		if (year % 4 == 0 && year != 100 || year % 400 == 0) {
			flg = true;
		}
		return flg;
	}
	/**
	 * [weekly]
	 * 与えられた日数と曜日から、経過前の曜日を表示。
	 * @param  weekly ]
	 * @param  days   ]
	 */
	public static void weekly(int weekly, int days) {
		int week = weekly - days % 7;
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
		}
	}
	/**
	 * main
	 */
	public static void main(String[] args) {
		getPassedDays(1989, 7, 9, 2020, 1, 22, 3);

	}
}