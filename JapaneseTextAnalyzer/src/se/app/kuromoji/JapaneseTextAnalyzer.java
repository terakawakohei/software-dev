package se.app.kuromoji;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

//Kuromojiのクラスをインポート
import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;

public class JapaneseTextAnalyzer {

	public static void main(String[] args) throws Exception {
		// Kuromojiの日本語解析器
		Tokenizer tokenizer = Tokenizer.builder().build();

		// キーボード入力用のいつものやつ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		// 空行でない限り繰り返し
		do {

			System.out.print("■日本語入力：");
			line = br.readLine(); // 1行読み込んで

			// 解析器で解析する．結果は，分かち書きされた単語（Token）のリスト
			List<Token> list = tokenizer.tokenize(line);

			// 各トークンの内容を表示
			for (Token token : list) {
				System.out.println(token.getSurfaceForm() + "\t" + token.getAllFeatures());
			}

		} while (!line.equals(""));

		System.out.println("終了します．");

	}
}