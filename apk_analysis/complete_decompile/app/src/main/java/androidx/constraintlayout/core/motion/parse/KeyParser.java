package androidx.constraintlayout.core.motion.parse;

import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import java.util.Arrays;
import p000.ly2;

/* loaded from: classes.dex */
public class KeyParser {
    public static void main(String[] strArr) {
        parseAttributes("{frame:22,\ntarget:'widget1',\neasing:'easeIn',\ncurveFit:'spline',\nprogress:0.3,\nalpha:0.2,\nelevation:0.7,\nrotationZ:23,\nrotationX:25.0,\nrotationY:27.0,\npivotX:15,\npivotY:17,\npivotTarget:'32',\npathRotate:23,\nscaleX:0.5,\nscaleY:0.7,\ntranslationX:5,\ntranslationY:7,\ntranslationZ:11,\n}");
    }

    public static TypedBundle parseAttributes(String str) {
        TypedBundle typedBundle = new TypedBundle();
        try {
            CLObject parse = CLParser.parse(str);
            int size = parse.size();
            for (int i = 0; i < size; i++) {
                CLKey cLKey = (CLKey) parse.get(i);
                String content = cLKey.content();
                CLElement value = cLKey.getValue();
                int m5999a = ly2.m5999a(content);
                if (m5999a == -1) {
                    System.err.println("unknown type " + content);
                } else {
                    int m6000b = ly2.m6000b(m5999a);
                    if (m6000b != 1) {
                        if (m6000b != 2) {
                            if (m6000b != 4) {
                                if (m6000b == 8) {
                                    typedBundle.add(m5999a, value.content());
                                    System.out.println("parse " + content + " STRING_MASK > " + value.content());
                                }
                            } else {
                                typedBundle.add(m5999a, value.getFloat());
                                System.out.println("parse " + content + " FLOAT_MASK > " + value.getFloat());
                            }
                        } else {
                            typedBundle.add(m5999a, value.getInt());
                            System.out.println("parse " + content + " INT_MASK > " + value.getInt());
                        }
                    } else {
                        typedBundle.add(m5999a, parse.getBoolean(i));
                    }
                }
            }
        } catch (CLParsingException e) {
            System.err.println(e.toString() + "\n" + Arrays.toString(e.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
        }
        return typedBundle;
    }
}
