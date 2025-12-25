package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class KeyFrames {
    public static final int UNSET = -1;

    /* renamed from: b */
    public static final HashMap f2738b;

    /* renamed from: a */
    public final HashMap f2739a = new HashMap();

    static {
        HashMap hashMap = new HashMap();
        f2738b = hashMap;
        try {
            hashMap.put("KeyAttribute", KeyAttributes.class.getConstructor(null));
            hashMap.put(TypedValues.PositionType.NAME, KeyPosition.class.getConstructor(null));
            hashMap.put(TypedValues.CycleType.NAME, KeyCycle.class.getConstructor(null));
            hashMap.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor(null));
            hashMap.put(TypedValues.TriggerType.NAME, KeyTrigger.class.getConstructor(null));
        } catch (NoSuchMethodException e) {
            Log.e("KeyFrames", "unable to load", e);
        }
    }

    public KeyFrames() {
    }

    public void addAllFrames(MotionController motionController) {
        ArrayList arrayList = (ArrayList) this.f2739a.get(-1);
        if (arrayList != null) {
            motionController.f2818w.addAll(arrayList);
        }
    }

    public void addFrames(MotionController motionController) {
        boolean z;
        HashMap hashMap = this.f2739a;
        ArrayList arrayList = (ArrayList) hashMap.get(Integer.valueOf(motionController.f2798c));
        if (arrayList != null) {
            motionController.f2818w.addAll(arrayList);
        }
        ArrayList arrayList2 = (ArrayList) hashMap.get(-1);
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Key key = (Key) it.next();
                String str = ((ConstraintLayout.LayoutParams) motionController.f2797b.getLayoutParams()).constraintTag;
                String str2 = key.f2702c;
                if (str2 != null && str != null) {
                    z = str.matches(str2);
                } else {
                    z = false;
                }
                if (z) {
                    motionController.addKey(key);
                }
            }
        }
    }

    public void addKey(Key key) {
        Integer valueOf = Integer.valueOf(key.f2701b);
        HashMap hashMap = this.f2739a;
        if (!hashMap.containsKey(valueOf)) {
            hashMap.put(Integer.valueOf(key.f2701b), new ArrayList());
        }
        ArrayList arrayList = (ArrayList) hashMap.get(Integer.valueOf(key.f2701b));
        if (arrayList != null) {
            arrayList.add(key);
        }
    }

    public ArrayList<Key> getKeyFramesForView(int i) {
        return (ArrayList) this.f2739a.get(Integer.valueOf(i));
    }

    public Set<Integer> getKeys() {
        return this.f2739a.keySet();
    }

    public KeyFrames(Context context, XmlPullParser xmlPullParser) {
        HashMap hashMap;
        HashMap hashMap2;
        char c;
        Key keyAttributes;
        try {
            int eventType = xmlPullParser.getEventType();
            Key key = null;
            while (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3 && ViewTransition.KEY_FRAME_SET_TAG.equals(xmlPullParser.getName())) {
                        return;
                    }
                } else {
                    String name = xmlPullParser.getName();
                    if (f2738b.containsKey(name)) {
                        switch (name.hashCode()) {
                            case -300573030:
                                if (name.equals("KeyTimeCycle")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case -298435811:
                                if (name.equals("KeyAttribute")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 540053991:
                                if (name.equals(TypedValues.CycleType.NAME)) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 1153397896:
                                if (name.equals(TypedValues.PositionType.NAME)) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 1308496505:
                                if (name.equals(TypedValues.TriggerType.NAME)) {
                                    c = 4;
                                    break;
                                }
                                break;
                        }
                        c = 65535;
                        if (c == 0) {
                            keyAttributes = new KeyAttributes();
                        } else if (c == 1) {
                            keyAttributes = new KeyPosition();
                        } else if (c == 2) {
                            keyAttributes = new KeyCycle();
                        } else if (c == 3) {
                            keyAttributes = new KeyTimeCycle();
                        } else if (c == 4) {
                            keyAttributes = new KeyTrigger();
                        } else {
                            throw new NullPointerException("Key " + name + " not found");
                        }
                        keyAttributes.load(context, Xml.asAttributeSet(xmlPullParser));
                        addKey(keyAttributes);
                        key = keyAttributes;
                    } else if (name.equalsIgnoreCase(ViewTransition.CUSTOM_ATTRIBUTE)) {
                        if (key != null && (hashMap2 = key.f2703d) != null) {
                            ConstraintAttribute.parse(context, xmlPullParser, hashMap2);
                        }
                    } else if (name.equalsIgnoreCase(ViewTransition.CUSTOM_METHOD) && key != null && (hashMap = key.f2703d) != null) {
                        ConstraintAttribute.parse(context, xmlPullParser, hashMap);
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e) {
            Log.e("KeyFrames", "Error parsing XML resource", e);
        } catch (XmlPullParserException e2) {
            Log.e("KeyFrames", "Error parsing XML resource", e2);
        }
    }
}
