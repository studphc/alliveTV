package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class StateSet {
    public static final String TAG = "ConstraintLayoutStates";

    /* renamed from: a */
    public final int f3210a;

    /* renamed from: b */
    public final SparseArray f3211b = new SparseArray();

    /* JADX WARN: Failed to find 'out' block for switch in B:30:0x0063. Please report as an issue. */
    public StateSet(Context context, XmlPullParser xmlPullParser) {
        this.f3210a = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.StateSet);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.StateSet_defaultState) {
                this.f3210a = obtainStyledAttributes.getResourceId(index, this.f3210a);
            }
        }
        obtainStyledAttributes.recycle();
        try {
            int eventType = xmlPullParser.getEventType();
            C0136h c0136h = null;
            while (true) {
                char c = 1;
                if (eventType != 1) {
                    if (eventType != 2) {
                        if (eventType != 3) {
                            continue;
                        } else if ("StateSet".equals(xmlPullParser.getName())) {
                            return;
                        }
                    } else {
                        String name = xmlPullParser.getName();
                        switch (name.hashCode()) {
                            case 80204913:
                                if (name.equals("State")) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1301459538:
                                if (name.equals("LayoutDescription")) {
                                    c = 0;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1382829617:
                                if (name.equals("StateSet")) {
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1901439077:
                                if (name.equals("Variant")) {
                                    c = 3;
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        if (c != 2) {
                            if (c == 3) {
                                C0137i c0137i = new C0137i(context, xmlPullParser);
                                if (c0136h != null) {
                                    c0136h.f3254b.add(c0137i);
                                }
                            }
                        } else {
                            c0136h = new C0136h(context, xmlPullParser);
                            this.f3211b.put(c0136h.f3253a, c0136h);
                        }
                    }
                    eventType = xmlPullParser.next();
                } else {
                    return;
                }
            }
        } catch (IOException e) {
            Log.e("ConstraintLayoutStates", "Error parsing XML resource", e);
        } catch (XmlPullParserException e2) {
            Log.e("ConstraintLayoutStates", "Error parsing XML resource", e2);
        }
    }

    public int convertToConstraintSet(int i, int i2, float f, float f2) {
        C0136h c0136h = (C0136h) this.f3211b.get(i2);
        if (c0136h == null) {
            return i2;
        }
        ArrayList arrayList = c0136h.f3254b;
        int i3 = c0136h.f3255c;
        if (f != -1.0f && f2 != -1.0f) {
            Iterator it = arrayList.iterator();
            C0137i c0137i = null;
            while (it.hasNext()) {
                C0137i c0137i2 = (C0137i) it.next();
                if (c0137i2.m687a(f, f2)) {
                    if (i == c0137i2.f3260e) {
                        return i;
                    }
                    c0137i = c0137i2;
                }
            }
            if (c0137i != null) {
                return c0137i.f3260e;
            }
            return i3;
        }
        if (i3 == i) {
            return i;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (i == ((C0137i) it2.next()).f3260e) {
                return i;
            }
        }
        return i3;
    }

    public boolean needsToChange(int i, float f, float f2) {
        Object obj;
        if (-1 != i) {
            return true;
        }
        SparseArray sparseArray = this.f3211b;
        if (i == -1) {
            obj = sparseArray.valueAt(0);
        } else {
            obj = sparseArray.get(-1);
        }
        if (-1 != ((C0136h) obj).m686a(f, f2)) {
            return true;
        }
        return false;
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
    }

    public int stateGetConstraintID(int i, int i2, int i3) {
        return updateConstraints(-1, i, i2, i3);
    }

    public int updateConstraints(int i, int i2, float f, float f2) {
        C0136h c0136h;
        SparseArray sparseArray = this.f3211b;
        if (i == i2) {
            if (i2 == -1) {
                c0136h = (C0136h) sparseArray.valueAt(0);
            } else {
                c0136h = (C0136h) sparseArray.get(-1);
            }
            if (c0136h == null) {
                return -1;
            }
            ArrayList arrayList = c0136h.f3254b;
            int m686a = c0136h.m686a(f, f2);
            if (i == m686a) {
                return i;
            }
            if (m686a == -1) {
                return c0136h.f3255c;
            }
            return ((C0137i) arrayList.get(m686a)).f3260e;
        }
        C0136h c0136h2 = (C0136h) sparseArray.get(i2);
        if (c0136h2 == null) {
            return -1;
        }
        int m686a2 = c0136h2.m686a(f, f2);
        if (m686a2 == -1) {
            return c0136h2.f3255c;
        }
        return ((C0137i) c0136h2.f3254b.get(m686a2)).f3260e;
    }
}
