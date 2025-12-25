package com.google.android.gms.internal.measurement;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;
import p000.o63;
import p000.uc3;

/* renamed from: com.google.android.gms.internal.measurement.c */
/* loaded from: classes.dex */
public abstract class AbstractC0783c {

    /* renamed from: a */
    public static final char[] f13751a;

    static {
        char[] cArr = new char[80];
        f13751a = cArr;
        Arrays.fill(cArr, ' ');
    }

    /* renamed from: a */
    public static void m3220a(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                m3220a(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                m3220a(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        m3221b(sb, i);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i2 = 1; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (Character.isUpperCase(charAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(charAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            zzld zzldVar = zzld.zzb;
            sb.append(o63.m6461X(new uc3(((String) obj).getBytes(zzmk.f13887a))));
            sb.append(Typography.quote);
            return;
        }
        if (obj instanceof zzld) {
            sb.append(": \"");
            sb.append(o63.m6461X((zzld) obj));
            sb.append(Typography.quote);
            return;
        }
        if (obj instanceof zzmd) {
            sb.append(" {");
            m3222c((zzmd) obj, sb, i + 2);
            sb.append("\n");
            m3221b(sb, i);
            sb.append("}");
            return;
        }
        if (obj instanceof Map.Entry) {
            int i3 = i + 2;
            sb.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            m3220a(sb, i3, "key", entry.getKey());
            m3220a(sb, i3, "value", entry.getValue());
            sb.append("\n");
            m3221b(sb, i);
            sb.append("}");
            return;
        }
        sb.append(": ");
        sb.append(obj);
    }

    /* renamed from: b */
    public static void m3221b(StringBuilder sb, int i) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(f13751a, 0, i2);
            i -= i2;
        }
    }

    /* renamed from: c */
    public static void m3222c(zzmd zzmdVar, StringBuilder sb, int i) {
        int i2;
        boolean equals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzmdVar.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i3 = 0;
        while (true) {
            i2 = 3;
            if (i3 >= length) {
                break;
            }
            Method method3 = declaredMethods[i3];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i3++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i2);
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                m3220a(sb, i, substring.substring(0, substring.length() - 4), zzmd.m3470c(method2, zzmdVar, new Object[0]));
            } else if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                m3220a(sb, i, substring.substring(0, substring.length() - 3), zzmd.m3470c(method, zzmdVar, new Object[0]));
            } else if (hashSet.contains("set".concat(substring)) && (!substring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) hashMap.get("has".concat(substring));
                if (method4 != null) {
                    Object m3470c = zzmd.m3470c(method4, zzmdVar, new Object[0]);
                    if (method5 == null) {
                        if (m3470c instanceof Boolean) {
                            if (!((Boolean) m3470c).booleanValue()) {
                            }
                            m3220a(sb, i, substring, m3470c);
                        } else if (m3470c instanceof Integer) {
                            if (((Integer) m3470c).intValue() == 0) {
                            }
                            m3220a(sb, i, substring, m3470c);
                        } else if (m3470c instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) m3470c).floatValue()) == 0) {
                            }
                            m3220a(sb, i, substring, m3470c);
                        } else if (m3470c instanceof Double) {
                            if (Double.doubleToRawLongBits(((Double) m3470c).doubleValue()) == 0) {
                            }
                            m3220a(sb, i, substring, m3470c);
                        } else {
                            if (m3470c instanceof String) {
                                equals = m3470c.equals("");
                            } else if (m3470c instanceof zzld) {
                                equals = m3470c.equals(zzld.zzb);
                            } else if (m3470c instanceof zznh) {
                                if (m3470c == ((zznh) m3470c).zzcC()) {
                                }
                                m3220a(sb, i, substring, m3470c);
                            } else {
                                if ((m3470c instanceof Enum) && ((Enum) m3470c).ordinal() == 0) {
                                }
                                m3220a(sb, i, substring, m3470c);
                            }
                            if (equals) {
                            }
                            m3220a(sb, i, substring, m3470c);
                        }
                    } else {
                        if (!((Boolean) zzmd.m3470c(method5, zzmdVar, new Object[0])).booleanValue()) {
                        }
                        m3220a(sb, i, substring, m3470c);
                    }
                }
            }
            i2 = 3;
        }
        if (zzmdVar instanceof zzma) {
            Iterator m71b = ((zzma) zzmdVar).zzb.m71b();
            if (m71b.hasNext()) {
                ((Map.Entry) m71b.next()).getKey().getClass();
                throw new ClassCastException();
            }
        }
        zzof zzofVar = zzmdVar.zzc;
        if (zzofVar != null) {
            for (int i4 = 0; i4 < zzofVar.f13894a; i4++) {
                m3220a(sb, i, String.valueOf(zzofVar.f13895b[i4] >>> 3), zzofVar.f13896c[i4]);
            }
        }
    }
}
