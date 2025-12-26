package p000;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import androidx.appcompat.widget.ActivityChooserModel$ActivityResolveInfo;
import androidx.appcompat.widget.ActivityChooserModel$HistoricalRecord;
import androidx.appcompat.widget.C0106o;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: u4 */
/* loaded from: classes.dex */
public final class C1859u4 extends DataSetObservable {

    /* renamed from: n */
    public static final Object f27084n = new Object();

    /* renamed from: o */
    public static final HashMap f27085o = new HashMap();

    /* renamed from: d */
    public final Context f27089d;

    /* renamed from: e */
    public final String f27090e;

    /* renamed from: f */
    public Intent f27091f;

    /* renamed from: m */
    public C0106o f27098m;

    /* renamed from: a */
    public final Object f27086a = new Object();

    /* renamed from: b */
    public final ArrayList f27087b = new ArrayList();

    /* renamed from: c */
    public final ArrayList f27088c = new ArrayList();

    /* renamed from: g */
    public final C1785s4 f27092g = new C1785s4(0);

    /* renamed from: h */
    public final int f27093h = 50;

    /* renamed from: i */
    public boolean f27094i = true;

    /* renamed from: j */
    public boolean f27095j = false;

    /* renamed from: k */
    public boolean f27096k = true;

    /* renamed from: l */
    public boolean f27097l = false;

    public C1859u4(Context context, String str) {
        this.f27089d = context.getApplicationContext();
        if (!TextUtils.isEmpty(str) && !str.endsWith(".xml")) {
            this.f27090e = str.concat(".xml");
        } else {
            this.f27090e = str;
        }
    }

    /* renamed from: d */
    public static C1859u4 m7532d(Context context, String str) {
        C1859u4 c1859u4;
        synchronized (f27084n) {
            try {
                HashMap hashMap = f27085o;
                c1859u4 = (C1859u4) hashMap.get(str);
                if (c1859u4 == null) {
                    c1859u4 = new C1859u4(context, str);
                    hashMap.put(str, c1859u4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c1859u4;
    }

    /* renamed from: a */
    public final void m7533a(ActivityChooserModel$HistoricalRecord activityChooserModel$HistoricalRecord) {
        int i = 0;
        ArrayList arrayList = this.f27088c;
        if (arrayList.add(activityChooserModel$HistoricalRecord)) {
            this.f27096k = true;
            m7539h();
            if (this.f27095j) {
                if (this.f27096k) {
                    this.f27096k = false;
                    String str = this.f27090e;
                    if (!TextUtils.isEmpty(str)) {
                        new AsyncTaskC1822t4(i, this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(arrayList), str);
                    }
                }
                m7540i();
                notifyChanged();
                return;
            }
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
    }

    /* renamed from: b */
    public final Intent m7534b(int i) {
        synchronized (this.f27086a) {
            try {
                if (this.f27091f == null) {
                    return null;
                }
                m7535c();
                ActivityInfo activityInfo = ((ActivityChooserModel$ActivityResolveInfo) this.f27087b.get(i)).resolveInfo.activityInfo;
                ComponentName componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
                Intent intent = new Intent(this.f27091f);
                intent.setComponent(componentName);
                if (this.f27098m != null) {
                    this.f27098m.onChooseActivity(this, new Intent(intent));
                }
                m7533a(new ActivityChooserModel$HistoricalRecord(componentName, System.currentTimeMillis(), 1.0f));
                return intent;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0085, code lost:
    
        if (r2 != 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00fa, code lost:
    
        if (r2 == 0) goto L59;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v2, types: [org.xmlpull.v1.XmlPullParser] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m7535c() {
        boolean z;
        boolean z2 = true;
        boolean z3 = this.f27097l;
        ?? r2 = this.f27089d;
        if (z3 && this.f27091f != null) {
            this.f27097l = false;
            ArrayList arrayList = this.f27087b;
            arrayList.clear();
            List<ResolveInfo> queryIntentActivities = r2.getPackageManager().queryIntentActivities(this.f27091f, 0);
            int size = queryIntentActivities.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(new ActivityChooserModel$ActivityResolveInfo(queryIntentActivities.get(i)));
            }
            z = true;
        } else {
            z = false;
        }
        if (this.f27094i && this.f27096k) {
            String str = this.f27090e;
            if (!TextUtils.isEmpty(str)) {
                this.f27094i = false;
                this.f27095j = true;
                try {
                    try {
                        r2 = r2.openFileInput(str);
                        try {
                            ?? newPullParser = Xml.newPullParser();
                            newPullParser.setInput(r2, "UTF-8");
                            for (int i2 = 0; i2 != 1 && i2 != 2; i2 = newPullParser.next()) {
                            }
                            if ("historical-records".equals(newPullParser.getName())) {
                                ArrayList arrayList2 = this.f27088c;
                                arrayList2.clear();
                                while (true) {
                                    int next = newPullParser.next();
                                    if (next != 1) {
                                        if (next != 3 && next != 4) {
                                            if ("historical-record".equals(newPullParser.getName())) {
                                                arrayList2.add(new ActivityChooserModel$HistoricalRecord(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                                            } else {
                                                throw new XmlPullParserException("Share records file not well-formed.");
                                            }
                                        }
                                    }
                                }
                            } else {
                                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                            }
                        } catch (IOException e) {
                            Log.e("u4", "Error reading historical recrod file: " + str, e);
                            if (r2 != 0) {
                                r2.close();
                            }
                        } catch (XmlPullParserException e2) {
                            Log.e("u4", "Error reading historical recrod file: " + str, e2);
                        }
                    } catch (FileNotFoundException | IOException unused) {
                    }
                } catch (Throwable th) {
                    if (r2 != 0) {
                        try {
                            r2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            }
        }
        z2 = false;
        boolean z4 = z2 | z;
        m7539h();
        if (z4) {
            m7540i();
            notifyChanged();
        }
    }

    /* renamed from: e */
    public final ResolveInfo m7536e(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.f27086a) {
            m7535c();
            resolveInfo = ((ActivityChooserModel$ActivityResolveInfo) this.f27087b.get(i)).resolveInfo;
        }
        return resolveInfo;
    }

    /* renamed from: f */
    public final int m7537f() {
        int size;
        synchronized (this.f27086a) {
            m7535c();
            size = this.f27087b.size();
        }
        return size;
    }

    /* renamed from: g */
    public final ResolveInfo m7538g() {
        synchronized (this.f27086a) {
            try {
                m7535c();
                if (!this.f27087b.isEmpty()) {
                    return ((ActivityChooserModel$ActivityResolveInfo) this.f27087b.get(0)).resolveInfo;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: h */
    public final void m7539h() {
        ArrayList arrayList = this.f27088c;
        int size = arrayList.size() - this.f27093h;
        if (size <= 0) {
            return;
        }
        this.f27096k = true;
        for (int i = 0; i < size; i++) {
        }
    }

    /* renamed from: i */
    public final void m7540i() {
        C1785s4 c1785s4 = this.f27092g;
        if (c1785s4 != null && this.f27091f != null) {
            ArrayList arrayList = this.f27087b;
            if (!arrayList.isEmpty()) {
                ArrayList arrayList2 = this.f27088c;
                if (!arrayList2.isEmpty()) {
                    c1785s4.sort(this.f27091f, arrayList, Collections.unmodifiableList(arrayList2));
                }
            }
        }
    }
}
