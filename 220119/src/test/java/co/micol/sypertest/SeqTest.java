package co.micol.sypertest;

public class SeqTest {
	public static long seq = 20;

	public static void main(String[] args) {
		// 9자리로 1씩 증가된 값을 생성, 랜덤, 시간,

//		String result = "";
//		seq++;
//		String strSeq = "00000000" + seq;
//		result = strSeq.substring(-9);
//
//		long t = System.nanoTime();
//		result = Long.toString(t).substring(-9);
//
		long t1 = System.currentTimeMillis();
		String result = String.valueOf(t1);
		result = result.substring(result.length() - 9);

		System.out.println(result);
	}
}
