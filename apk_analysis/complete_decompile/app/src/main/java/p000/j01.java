package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.google.firebase.heartbeatinfo.HeartBeatResult;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class j01 {

    /* renamed from: a */
    public final SharedPreferences f20328a;

    public j01(Context context, String str) {
        this.f20328a = context.getSharedPreferences("FirebaseHeartBeat" + str, 0);
    }

    /* renamed from: a */
    public final synchronized void m5370a() {
        try {
            long j = this.f20328a.getLong("fire-count", 0L);
            String str = "";
            String str2 = null;
            for (Map.Entry<String, ?> entry : this.f20328a.getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    for (String str3 : (Set) entry.getValue()) {
                        if (str2 != null && str2.compareTo(str3) <= 0) {
                        }
                        str = entry.getKey();
                        str2 = str3;
                    }
                }
            }
            HashSet hashSet = new HashSet(this.f20328a.getStringSet(str, new HashSet()));
            hashSet.remove(str2);
            this.f20328a.edit().putStringSet(str, hashSet).putLong("fire-count", j - 1).commit();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: b */
    public final synchronized void m5371b() {
        try {
            SharedPreferences.Editor edit = this.f20328a.edit();
            int i = 0;
            for (Map.Entry<String, ?> entry : this.f20328a.getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    Set set = (Set) entry.getValue();
                    String m5373d = m5373d(System.currentTimeMillis());
                    String key = entry.getKey();
                    if (set.contains(m5373d)) {
                        HashSet hashSet = new HashSet();
                        hashSet.add(m5373d);
                        i++;
                        edit.putStringSet(key, hashSet);
                    } else {
                        edit.remove(key);
                    }
                }
            }
            if (i == 0) {
                edit.remove("fire-count");
            } else {
                edit.putLong("fire-count", i);
            }
            edit.commit();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: c */
    public final synchronized ArrayList m5372c() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (Map.Entry<String, ?> entry : this.f20328a.getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    HashSet hashSet = new HashSet((Set) entry.getValue());
                    hashSet.remove(m5373d(System.currentTimeMillis()));
                    if (!hashSet.isEmpty()) {
                        arrayList.add(HeartBeatResult.create(entry.getKey(), new ArrayList(hashSet)));
                    }
                }
            }
            m5381l(System.currentTimeMillis());
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    /* renamed from: d */
    public final synchronized String m5373d(long j) {
        Instant instant;
        ZoneOffset zoneOffset;
        OffsetDateTime atOffset;
        LocalDateTime localDateTime;
        DateTimeFormatter dateTimeFormatter;
        String format;
        if (Build.VERSION.SDK_INT >= 26) {
            instant = new Date(j).toInstant();
            zoneOffset = ZoneOffset.UTC;
            atOffset = instant.atOffset(zoneOffset);
            localDateTime = atOffset.toLocalDateTime();
            dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
            format = localDateTime.format(dateTimeFormatter);
            return format;
        }
        return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j));
    }

    /* renamed from: e */
    public final synchronized String m5374e(String str) {
        for (Map.Entry<String, ?> entry : this.f20328a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return entry.getKey();
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: f */
    public final synchronized boolean m5375f(long j, long j2) {
        return m5373d(j).equals(m5373d(j2));
    }

    /* renamed from: g */
    public final synchronized void m5376g() {
        String m5373d = m5373d(System.currentTimeMillis());
        this.f20328a.edit().putString("last-used-date", m5373d).commit();
        m5377h(m5373d);
    }

    /* renamed from: h */
    public final synchronized void m5377h(String str) {
        try {
            String m5374e = m5374e(str);
            if (m5374e == null) {
                return;
            }
            HashSet hashSet = new HashSet(this.f20328a.getStringSet(m5374e, new HashSet()));
            hashSet.remove(str);
            if (hashSet.isEmpty()) {
                this.f20328a.edit().remove(m5374e).commit();
            } else {
                this.f20328a.edit().putStringSet(m5374e, hashSet).commit();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: i */
    public final synchronized boolean m5378i(long j) {
        return m5379j(j);
    }

    /* renamed from: j */
    public final synchronized boolean m5379j(long j) {
        if (this.f20328a.contains("fire-global")) {
            if (!m5375f(this.f20328a.getLong("fire-global", -1L), j)) {
                this.f20328a.edit().putLong("fire-global", j).commit();
                return true;
            }
            return false;
        }
        this.f20328a.edit().putLong("fire-global", j).commit();
        return true;
    }

    /* renamed from: k */
    public final synchronized void m5380k(long j, String str) {
        String m5373d = m5373d(j);
        if (this.f20328a.getString("last-used-date", "").equals(m5373d)) {
            String m5374e = m5374e(m5373d);
            if (m5374e == null) {
                return;
            }
            if (m5374e.equals(str)) {
                return;
            }
            m5382m(str, m5373d);
            return;
        }
        long j2 = this.f20328a.getLong("fire-count", 0L);
        if (j2 + 1 == 30) {
            m5370a();
            j2 = this.f20328a.getLong("fire-count", 0L);
        }
        HashSet hashSet = new HashSet(this.f20328a.getStringSet(str, new HashSet()));
        hashSet.add(m5373d);
        this.f20328a.edit().putStringSet(str, hashSet).putLong("fire-count", j2 + 1).putString("last-used-date", m5373d).commit();
    }

    /* renamed from: l */
    public final synchronized void m5381l(long j) {
        this.f20328a.edit().putLong("fire-global", j).commit();
    }

    /* renamed from: m */
    public final synchronized void m5382m(String str, String str2) {
        m5377h(str2);
        HashSet hashSet = new HashSet(this.f20328a.getStringSet(str, new HashSet()));
        hashSet.add(str2);
        this.f20328a.edit().putStringSet(str, hashSet).commit();
    }
}
