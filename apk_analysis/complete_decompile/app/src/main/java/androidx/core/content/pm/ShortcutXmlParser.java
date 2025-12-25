package androidx.core.content.pm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class ShortcutXmlParser {

    /* renamed from: a */
    public static volatile ArrayList f3604a;

    /* renamed from: b */
    public static final Object f3605b = new Object();

    /* renamed from: a */
    public static HashSet m813a(Context context) {
        HashSet hashSet = new HashSet();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 128);
        if (queryIntentActivities != null && queryIntentActivities.size() != 0) {
            try {
                Iterator<ResolveInfo> it = queryIntentActivities.iterator();
                while (it.hasNext()) {
                    ActivityInfo activityInfo = it.next().activityInfo;
                    Bundle bundle = activityInfo.metaData;
                    if (bundle != null && bundle.containsKey("android.app.shortcuts")) {
                        XmlResourceParser loadXmlMetaData = activityInfo.loadXmlMetaData(context.getPackageManager(), "android.app.shortcuts");
                        if (loadXmlMetaData != null) {
                            try {
                                hashSet.addAll(parseShortcutIds(loadXmlMetaData));
                                loadXmlMetaData.close();
                            } finally {
                            }
                        } else {
                            throw new IllegalArgumentException("Failed to open android.app.shortcuts meta-data resource of " + activityInfo.name);
                        }
                    }
                }
            } catch (Exception e) {
                Log.e("ShortcutXmlParser", "Failed to parse the Xml resource: ", e);
            }
        }
        return hashSet;
    }

    @NonNull
    @WorkerThread
    public static List<String> getShortcutIds(@NonNull Context context) {
        if (f3604a == null) {
            synchronized (f3605b) {
                try {
                    if (f3604a == null) {
                        f3604a = new ArrayList();
                        f3604a.addAll(m813a(context));
                    }
                } finally {
                }
            }
        }
        return f3604a;
    }

    @NonNull
    @VisibleForTesting
    public static List<String> parseShortcutIds(@NonNull XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList(1);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || (next == 3 && xmlPullParser.getDepth() <= 0)) {
                break;
            }
            int depth = xmlPullParser.getDepth();
            String name = xmlPullParser.getName();
            if (next == 2 && depth == 2 && "shortcut".equals(name)) {
                String attributeValue = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "shortcutId");
                if (attributeValue == null) {
                    attributeValue = xmlPullParser.getAttributeValue(null, "shortcutId");
                }
                if (attributeValue != null) {
                    arrayList.add(attributeValue);
                }
            }
        }
        return arrayList;
    }
}
