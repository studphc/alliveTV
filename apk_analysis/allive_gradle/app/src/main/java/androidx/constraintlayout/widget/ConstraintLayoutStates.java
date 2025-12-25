package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class ConstraintLayoutStates {
    public static final String TAG = "ConstraintLayoutStates";

    /* renamed from: a */
    public final ConstraintLayout f3172a;

    /* renamed from: b */
    public int f3173b = -1;

    /* renamed from: c */
    public int f3174c = -1;

    /* renamed from: d */
    public final SparseArray f3175d = new SparseArray();

    /* renamed from: e */
    public final SparseArray f3176e = new SparseArray();

    /* renamed from: f */
    public ConstraintsChangedListener f3177f = null;

    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x003d. Please report as an issue. */
    public ConstraintLayoutStates(Context context, ConstraintLayout constraintLayout, int i) {
        C0131c c0131c = null;
        this.f3172a = constraintLayout;
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            int eventType = xml.getEventType();
            while (true) {
                char c = 1;
                if (eventType != 1) {
                    if (eventType == 2) {
                        String name = xml.getName();
                        switch (name.hashCode()) {
                            case -1349929691:
                                if (name.equals("ConstraintSet")) {
                                    c = 4;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 80204913:
                                if (name.equals("State")) {
                                    c = 2;
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
                            case 1657696882:
                                if (name.equals("layoutDescription")) {
                                    c = 0;
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
                            if (c != 3) {
                                if (c == 4) {
                                    m633a(context, xml);
                                }
                            } else {
                                C0132d c0132d = new C0132d(context, xml);
                                if (c0131c != null) {
                                    c0131c.f3224b.add(c0132d);
                                }
                            }
                        } else {
                            c0131c = new C0131c(context, xml);
                            this.f3175d.put(c0131c.f3223a, c0131c);
                        }
                    }
                    eventType = xml.next();
                } else {
                    return;
                }
            }
        } catch (IOException e) {
            Log.e("ConstraintLayoutStates", "Error parsing resource: " + i, e);
        } catch (XmlPullParserException e2) {
            Log.e("ConstraintLayoutStates", "Error parsing resource: " + i, e2);
        }
    }

    /* renamed from: a */
    public final void m633a(Context context, XmlResourceParser xmlResourceParser) {
        int i;
        ConstraintSet constraintSet = new ConstraintSet();
        int attributeCount = xmlResourceParser.getAttributeCount();
        for (int i2 = 0; i2 < attributeCount; i2++) {
            String attributeName = xmlResourceParser.getAttributeName(i2);
            String attributeValue = xmlResourceParser.getAttributeValue(i2);
            if (attributeName != null && attributeValue != null && "id".equals(attributeName)) {
                if (attributeValue.contains("/")) {
                    i = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName());
                } else {
                    i = -1;
                }
                if (i == -1) {
                    if (attributeValue.length() > 1) {
                        i = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                constraintSet.load(context, xmlResourceParser);
                this.f3176e.put(i, constraintSet);
                return;
            }
        }
    }

    public boolean needsToChange(int i, float f, float f2) {
        Object obj;
        int i2 = this.f3173b;
        if (i2 != i) {
            return true;
        }
        SparseArray sparseArray = this.f3175d;
        if (i == -1) {
            obj = sparseArray.valueAt(0);
        } else {
            obj = sparseArray.get(i2);
        }
        C0131c c0131c = (C0131c) obj;
        int i3 = this.f3174c;
        if ((i3 == -1 || !((C0132d) c0131c.f3224b.get(i3)).m664a(f, f2)) && this.f3174c != c0131c.m663a(f, f2)) {
            return true;
        }
        return false;
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.f3177f = constraintsChangedListener;
    }

    public void updateConstraints(int i, float f, float f2) {
        ConstraintSet constraintSet;
        int i2;
        C0131c c0131c;
        int m663a;
        ConstraintSet constraintSet2;
        int i3;
        int i4 = this.f3173b;
        ConstraintLayout constraintLayout = this.f3172a;
        SparseArray sparseArray = this.f3175d;
        if (i4 == i) {
            if (i == -1) {
                c0131c = (C0131c) sparseArray.valueAt(0);
            } else {
                c0131c = (C0131c) sparseArray.get(i4);
            }
            int i5 = this.f3174c;
            if ((i5 != -1 && ((C0132d) c0131c.f3224b.get(i5)).m664a(f, f2)) || this.f3174c == (m663a = c0131c.m663a(f, f2))) {
                return;
            }
            ArrayList arrayList = c0131c.f3224b;
            if (m663a == -1) {
                constraintSet2 = null;
            } else {
                constraintSet2 = ((C0132d) arrayList.get(m663a)).f3232f;
            }
            if (m663a == -1) {
                i3 = c0131c.f3225c;
            } else {
                i3 = ((C0132d) arrayList.get(m663a)).f3231e;
            }
            if (constraintSet2 == null) {
                return;
            }
            this.f3174c = m663a;
            ConstraintsChangedListener constraintsChangedListener = this.f3177f;
            if (constraintsChangedListener != null) {
                constraintsChangedListener.preLayoutChange(-1, i3);
            }
            constraintSet2.applyTo(constraintLayout);
            ConstraintsChangedListener constraintsChangedListener2 = this.f3177f;
            if (constraintsChangedListener2 != null) {
                constraintsChangedListener2.postLayoutChange(-1, i3);
                return;
            }
            return;
        }
        this.f3173b = i;
        C0131c c0131c2 = (C0131c) sparseArray.get(i);
        int m663a2 = c0131c2.m663a(f, f2);
        ArrayList arrayList2 = c0131c2.f3224b;
        if (m663a2 == -1) {
            constraintSet = c0131c2.f3226d;
        } else {
            constraintSet = ((C0132d) arrayList2.get(m663a2)).f3232f;
        }
        if (m663a2 == -1) {
            i2 = c0131c2.f3225c;
        } else {
            i2 = ((C0132d) arrayList2.get(m663a2)).f3231e;
        }
        if (constraintSet == null) {
            Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i + ", dim =" + f + ", " + f2);
            return;
        }
        this.f3174c = m663a2;
        ConstraintsChangedListener constraintsChangedListener3 = this.f3177f;
        if (constraintsChangedListener3 != null) {
            constraintsChangedListener3.preLayoutChange(i, i2);
        }
        constraintSet.applyTo(constraintLayout);
        ConstraintsChangedListener constraintsChangedListener4 = this.f3177f;
        if (constraintsChangedListener4 != null) {
            constraintsChangedListener4.postLayoutChange(i, i2);
        }
    }
}
