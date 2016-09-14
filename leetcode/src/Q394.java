public class Q394 {

	public static int i = 0;

	public String decodeString(String s) {
		char[] c = s.toCharArray();
		StringBuffer res = new StringBuffer();

		// int i = 0;
		while (i < c.length) {
			if (c[i] >= '0' && c[i] <= '9') {
				res.append(get(c, i));
			} else {
				if (c[i] != ']') {
					res.append(c[i]);
				}
				i++;
			}
		}
		return res.toString();

	}

	private String get(char[] c, int start) {
		StringBuffer res = new StringBuffer();

		i = start;
		while (c[i] != ']') {
			// 进入就是数字
			StringBuffer num = new StringBuffer();
			StringBuffer string = new StringBuffer();
			// find number
			while (c[i] != '[') {

				num.append(c[i]);
				i++;
			}

			if (c[i++] == '[') {
				while (c[i] != ']') {
				
//					if (c[i] >= 'a' && c[i] <= 'z' || c[i] >= 'A'&& c[i] <= 'Z') {
						if (Character.isAlphabetic(c[i])) {

						string.append(c[i]);
					} else if (Character.isDigit(c[i])) {
//					} else if (c[i] >= '0' && c[i] <= '9') {
						String tmp = get(c, i);
						string.append(tmp);
					}
					i++;

				}
			}
			int len = Integer.valueOf(num.toString());
			String origin = string.toString();
			for (int j = 0; j < len - 1; j++) {
				string.append(origin);
			}

			res.append(string);
		}

		return res.toString();

	}

	public static void main(String[] args) {
		
		Q394 q = new Q394();
		String s1 = "2[abc]3[cd]ef";
		String s = "3[a2[c]]";
		String res = q.decodeString(s1);
		System.out.println(res);
	}
}
