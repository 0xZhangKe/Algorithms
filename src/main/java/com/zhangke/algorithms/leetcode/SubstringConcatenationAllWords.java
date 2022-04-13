package com.zhangke.algorithms.leetcode;

import com.zhangke.algorithms.Util;

import java.util.*;

/**
 * 30. 串联所有单词的子串:
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 * Created by ZhangKe on 2019/11/20.
 */
public class SubstringConcatenationAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        if (s.isEmpty()) return Collections.emptyList();
        if (words.length <= 0) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> wordsMap = new HashMap<>();
        Integer tmpInt;
        String tmpStr;
        for (String item : words) {
            tmpInt = wordsMap.get(item);
            wordsMap.put(item, tmpInt == null ? 0 : 1 + tmpInt);
        }
        int step = words[0].length();
        int totalLen = words.length * step;
        for (int i = 0; i < s.length() - totalLen + 1; i++) {
            Map<String, Integer> tmp = new HashMap<>();
            for (int j = i; j < i + totalLen; j = j + step) {
                tmpStr = s.substring(j, j + step);
                tmpInt = tmp.get(tmpStr);
                tmp.put(tmpStr, tmpInt == null ? 0 : 1 + tmpInt);
            }
            if (tmp.equals(wordsMap)) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SubstringConcatenationAllWords sub = new SubstringConcatenationAllWords();
        String s = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
        String[] words = {"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};
        Util.printListElementWithLine(sub.findSubstring(s, words));
    }
}
