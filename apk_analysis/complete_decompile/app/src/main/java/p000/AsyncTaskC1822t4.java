package p000;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Xml;
import androidx.appcompat.widget.ActivityChooserModel$HistoricalRecord;
import androidx.core.app.JobIntentService;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: t4 */
/* loaded from: classes.dex */
public final class AsyncTaskC1822t4 extends AsyncTask {

    /* renamed from: a */
    public final /* synthetic */ int f26686a;

    /* renamed from: b */
    public final /* synthetic */ Object f26687b;

    public /* synthetic */ AsyncTaskC1822t4(int i, Object obj) {
        this.f26686a = i;
        this.f26687b = obj;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        k61 k61Var;
        int i = 0;
        String str = null;
        switch (this.f26686a) {
            case 0:
                String str2 = "historical-record";
                C1859u4 c1859u4 = (C1859u4) this.f26687b;
                List list = (List) objArr[0];
                String str3 = (String) objArr[1];
                try {
                    Context context = c1859u4.f27089d;
                    String str4 = c1859u4.f27090e;
                    FileOutputStream openFileOutput = context.openFileOutput(str3, 0);
                    XmlSerializer newSerializer = Xml.newSerializer();
                    try {
                        try {
                            try {
                                newSerializer.setOutput(openFileOutput, null);
                                newSerializer.startDocument("UTF-8", Boolean.TRUE);
                                newSerializer.startTag(null, "historical-records");
                                int size = list.size();
                                int i2 = 0;
                                while (i2 < size) {
                                    ActivityChooserModel$HistoricalRecord activityChooserModel$HistoricalRecord = (ActivityChooserModel$HistoricalRecord) list.remove(i);
                                    newSerializer.startTag(str, str2);
                                    newSerializer.attribute(str, "activity", activityChooserModel$HistoricalRecord.activity.flattenToString());
                                    String str5 = str2;
                                    newSerializer.attribute(null, "time", String.valueOf(activityChooserModel$HistoricalRecord.time));
                                    newSerializer.attribute(null, "weight", String.valueOf(activityChooserModel$HistoricalRecord.weight));
                                    newSerializer.endTag(null, str5);
                                    i2++;
                                    str2 = str5;
                                    i = 0;
                                    str = null;
                                }
                                newSerializer.endTag(str, "historical-records");
                                newSerializer.endDocument();
                                c1859u4.f27094i = true;
                                if (openFileOutput == null) {
                                    return null;
                                }
                            } catch (Throwable th) {
                                c1859u4.f27094i = true;
                                if (openFileOutput != null) {
                                    try {
                                        openFileOutput.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                throw th;
                            }
                        } catch (IllegalStateException e) {
                            Object obj = C1859u4.f27084n;
                            Log.e("u4", "Error writing historical record file: " + str4, e);
                            c1859u4.f27094i = true;
                            if (openFileOutput == null) {
                                return null;
                            }
                        }
                    } catch (IOException e2) {
                        Object obj2 = C1859u4.f27084n;
                        Log.e("u4", "Error writing historical record file: " + str4, e2);
                        c1859u4.f27094i = true;
                        if (openFileOutput == null) {
                            return null;
                        }
                    } catch (IllegalArgumentException e3) {
                        Object obj3 = C1859u4.f27084n;
                        Log.e("u4", "Error writing historical record file: " + str4, e3);
                        c1859u4.f27094i = true;
                        if (openFileOutput == null) {
                            return null;
                        }
                    }
                    try {
                        openFileOutput.close();
                    } catch (IOException unused2) {
                        return null;
                    }
                } catch (FileNotFoundException e4) {
                    Object obj4 = C1859u4.f27084n;
                    Log.e("u4", "Error writing historical record file: " + str3, e4);
                    return null;
                }
            default:
                while (true) {
                    JobIntentService jobIntentService = (JobIntentService) this.f26687b;
                    m61 m61Var = jobIntentService.f3278a;
                    if (m61Var != null) {
                        k61Var = m61Var.m6084a();
                    } else {
                        synchronized (jobIntentService.f3284g) {
                            try {
                                if (jobIntentService.f3284g.size() > 0) {
                                    k61Var = (k61) jobIntentService.f3284g.remove(0);
                                } else {
                                    k61Var = null;
                                }
                            } finally {
                            }
                        }
                    }
                    if (k61Var == null) {
                        return null;
                    }
                    ((JobIntentService) this.f26687b).onHandleWork(k61Var.getIntent());
                    k61Var.complete();
                }
        }
    }

    @Override // android.os.AsyncTask
    public void onCancelled(Object obj) {
        switch (this.f26686a) {
            case 1:
                ((JobIntentService) this.f26687b).m691c();
                return;
            default:
                super.onCancelled(obj);
                return;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        switch (this.f26686a) {
            case 1:
                ((JobIntentService) this.f26687b).m691c();
                return;
            default:
                super.onPostExecute(obj);
                return;
        }
    }
}
