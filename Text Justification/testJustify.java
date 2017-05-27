public class Solution {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> justified = new ArrayList<String>();
		String temp = "";
		int width = 0;
		ArrayList<String> tempArray = new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {
			if (width + words[i].length() > maxWidth) {
				width--;
				justified.add(justify(tempArray, maxWidth - width));
				tempArray.clear();
				width = 0;
			}
			width += words[i].length() + 1;
			tempArray.add(words[i]);
			if (i == words.length - 1) {
				width--;
				justified.add(leftJustify(tempArray, maxWidth - width));
			}
		}
		return justified;
	}

	public String justify(ArrayList<String> wordArray, int extra) {
		String temp = "";
		int distributed;
		int extraSpace;
		if (wordArray.size() > 1) {
			distributed = extra / (wordArray.size() - 1);
			extraSpace = extra % (wordArray.size() - 1);
		} else {
			temp = wordArray.get(0);
			for (int i = 0; i < extra; i++) {
				temp += " ";
			}
			return temp;
		}

		for (int i = 0; i < wordArray.size(); i++) {
			temp += wordArray.get(i);
			if (i != wordArray.size() - 1) {
				temp += " ";
				for (int k = 0; k < distributed; k++) {
					temp += " ";
				}
				if (extraSpace > 0) {
					temp += " ";
					extraSpace--;
				}
			}
		}
		return temp;
	}

	public String leftJustify(ArrayList<String> wordArray, int extra) {
		String temp = "";
		for (int i = 0; i < wordArray.size(); i++) {
			temp += wordArray.get(i);
			if (i != wordArray.size() - 1) {
				temp += " ";
			}
		}
		for (int k = 0; k < extra; k++) {
			temp += " ";
		}
		return temp;
	}
}
