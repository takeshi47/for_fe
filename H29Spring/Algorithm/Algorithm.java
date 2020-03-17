/**
 * FE
 * H29 Spring Algorithm
 *
 * 01/16 作成
 *
 */
public class Algorithm {
	//各地点間の距離
	static int[][] distance = {
		{0, 2, 8, 4, -1, -1, -1},
		{2, 0, -1, -1, 3, -1, -1},
		{8, -1, 0, -1, 2, 3, -1},
		{4, -1, -1, 0, -1, 1, -1},
		{-1, 3, 2, -1, 0, -1, 9},
		{-1, -1, 3, 8, -1, 0, 3},
		{-1, -1, -1, -1, 9, 3, 0}
	};
	static int sp = 0;      //出発地点を設定する
	static int dp = 5;      //目標地点
	static int nPoint = 7;  //地点数
	static int[] sRoute = new int[7];  //最短経路上の地点番号
	static int sDist = 0;   //最短経路の距離

	/**
	 * 最短経路探索
	 * shortestPath
	 *
	 * @param distance int[][]
	 * @param nPoint   int
	 * @param sp       int
	 * @param dp       int
	 * @param sRoute   int[]
	 * @param sDist    int
	 */
	public static void shortestPath(int[][] distance, int nPoint, int sp, int dp, int[] sRoute, int sDist) {

		//出発地から各地点までの最短距離を格納する
		int[] pDist = new int[nPoint];
		//出発地点から目標地点までの経路を格納する
		int[] pRoute = new int[nPoint];
		//最短距離が確定したかどうか(pDistが更新されたかどうか)を格納する。
		boolean[] pFixed = new boolean[nPoint];

		int sPoint, i, j, newDist;

		sDist = 1000;   //無限大の代わりに1000を代入しておく

		for (i = 0; i < nPoint; i++) {
			sRoute[i] = -1;       //最短経路の地点番号を初期化
			pDist[i] = 1000;      //出発地点から各地点までの最短距離を1000で初期化
			pFixed[i] = false;    //確定未確定の判定をfalseで初期化
			pRoute[i] = 0;        //最短距離での経由地の地点番号を初期化
			// System.out.println(pFixed[i]);
		}

		pDist[sp] = 0;          //出発地から出発地自体への最短距離に0を設定する

		//初期値を表示する
		System.out.println("初期値を表示する");
		//pFixedを表示
		System.out.print("pFixed = ");
		for (Boolean fixed : pFixed) {
			System.out.print(fixed + " : ");
		}
		System.out.println();
		//pDistを表示
		System.out.print("pDist = ");
		for (int dist : pDist ) {
			System.out.print(dist + " : ");
		}
		System.out.println();
		//pRouteを表示
		System.out.print("pRoute = ");
		for (int route : pRoute ) {
			System.out.print(route + " : ");
		}
		System.out.println("\n");
		//探索処理を行うループ
		while (true) {
			//iを増やしながら未確定箇所を探すループ
			for (i = 0; i < nPoint; i++) {
				if (!pFixed[i]) {   //i地点が未確定のとき
					System.out.println("地点:" + i + "からの経路は未確定なので隣接地点への距離を調べる");
					break;            //ループを抜ける
				}
			}

			//地点数を全てチェックしたら探索処理ループを抜ける
			if (i == nPoint) break;

			//未確定地点の中から最短距離がより短い点を探す
			for (j = i + 1; j < nPoint; j++ ) {
				if (!pFixed[j] && pDist[j] < pDist[i]) {
					System.out.println();
					System.out.println("出発点:" + sp + "から地点:" + j + "までの距離は" + "pDist[" + j + "]:" + pDist[j] +
					                   "\n地点:" + i + "のpDist[" + i + "]:" + pDist[i] + "より近い。");
					i = j;
				}
			}
			System.out.println();
			/*
			 * 未確定地点の中の出発地点からの距離が短い地点をsPointとし、
			 * 確定した状態に更新する
			 */
			sPoint = i;
			pFixed[sPoint] = true;
			System.out.println("地点:sPoint = " + sPoint + "からのそれぞれの地点までの距離は\n");

			/*
			 * 地点sPointの隣接点であるかどうか、かつ、出発地からの最短距離が未確定かを調べ、
			 * 該当するjに対して出発地点から地点sPointを経由して地点jに到達する経路の距離を求め、
			* すでに計算されているpDist[j]よりも短ければpDist[j]及びpRoute[j]を更新する。
			* pRoute[j]には地点ｊの直前の経由地の地点番号を設定する。
			*/
			for (j = 0; j < nPoint; j++) {
				if (distance[sPoint][j] > 0 && !pFixed[j]) {
					//sPointまでの最短距離とspoint~ｊ間の距離をnewDistに設定する
					newDist = pDist[sPoint] + distance[sPoint][j];
					System.out.println("地点:" + j + "までの距離は" + newDist);
					//設定されたnewDistがすでにある最短より短ければ
					if (newDist < pDist[j]) {
						//地点jまでの最短距離を更新する
						System.out.println("地点:" + j + "までの最短距離を更新する。");
						pDist[j] = newDist;
						//経路にjのひとつ前の地点(sPoint)を設定する。
						System.out.println("地点:" + j + "までの経由点に「" + sPoint + "」を設定する");
						pRoute[j] = sPoint;
						System.out.println();
					}
				}
			}
			System.out.println("pFixed[" + i + "]を確定する。");
			System.out.println();
			//pFixedを表示
			System.out.print("pFixed = ");
			for (Boolean fixed : pFixed) {
				System.out.print(fixed + " : ");
			}
			System.out.println();
			//pDistを表示
			System.out.print("pDist = ");
			for (int dist : pDist ) {
				System.out.print(dist + " : ");
			}
			System.out.println();
			//pRouteを表示
			System.out.print("pRoute = ");
			for (int route : pRoute ) {
				System.out.print(route + " : ");
			}
			System.out.println("\n");
		}

		//sDistに目標点までの最短距離を設定する
		sDist = pDist[dp];
		j = 0;
		i = dp;
		while (i != sp) {
			System.out.println("経由点:sRoute[" + j + "]を" + i + "に設定" );
			sRoute[j] = i;
			i = pRoute[i];
			j++;
		};
		System.out.println();
		//経由地の最後にスタート地点を設定
		sRoute[j] = sp;
		System.out.println("最短距離 sDist = " + sDist);
		System.out.print("経由地点 sRoute = ");
		for (int route : sRoute ) {
			System.out.print(route + " : ");
		}
	};

	/**
	 * メイン
	 */
	public static void main(String[] args) {
		shortestPath(distance, nPoint, sp, dp,
		             sRoute, 0);
	}
}