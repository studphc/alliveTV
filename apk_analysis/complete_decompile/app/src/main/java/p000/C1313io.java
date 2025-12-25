package p000;

/* renamed from: io */
/* loaded from: classes.dex */
public final class C1313io extends AbstractC1953wo {

    /* renamed from: d */
    public static final C1313io f18479d;

    /* JADX WARN: Type inference failed for: r0v0, types: [io, wo] */
    static {
        char[] charArray = "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".toCharArray();
        char[] cArr = new char[37];
        for (int i = 0; i < 37; i++) {
            cArr[i] = (char) ("0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".charAt(i) + '\t');
        }
        f18479d = new AbstractC1953wo("CharMatcher.digit()", charArray, cArr);
    }
}
