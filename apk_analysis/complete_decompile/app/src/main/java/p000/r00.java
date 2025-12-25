package p000;

import android.util.Base64OutputStream;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.heartbeatinfo.HeartBeatResult;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final /* synthetic */ class r00 implements Callable {

    /* renamed from: a */
    public final /* synthetic */ int f25817a;

    /* renamed from: b */
    public final /* synthetic */ DefaultHeartBeatController f25818b;

    public /* synthetic */ r00(DefaultHeartBeatController defaultHeartBeatController, int i) {
        this.f25817a = i;
        this.f25818b = defaultHeartBeatController;
    }

    /* renamed from: a */
    private final Object m7157a() {
        String byteArrayOutputStream;
        DefaultHeartBeatController defaultHeartBeatController = this.f25818b;
        synchronized (defaultHeartBeatController) {
            try {
                j01 j01Var = (j01) defaultHeartBeatController.f15559a.get();
                ArrayList m5372c = j01Var.m5372c();
                j01Var.m5371b();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < m5372c.size(); i++) {
                    HeartBeatResult heartBeatResult = (HeartBeatResult) m5372c.get(i);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("agent", heartBeatResult.getUserAgent());
                    jSONObject.put("dates", new JSONArray((Collection) heartBeatResult.getUsedDates()));
                    jSONArray.put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("heartbeats", jSONArray);
                jSONObject2.put("version", ExifInterface.GPS_MEASUREMENT_2D);
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream2, 11);
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                    try {
                        gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                        gZIPOutputStream.close();
                        base64OutputStream.close();
                        byteArrayOutputStream = byteArrayOutputStream2.toString("UTF-8");
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        base64OutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return byteArrayOutputStream;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f25817a) {
            case 0:
                return m7157a();
            default:
                DefaultHeartBeatController defaultHeartBeatController = this.f25818b;
                synchronized (defaultHeartBeatController) {
                    ((j01) defaultHeartBeatController.f15559a.get()).m5380k(System.currentTimeMillis(), ((UserAgentPublisher) defaultHeartBeatController.f15561c.get()).getUserAgent());
                }
                return null;
        }
    }
}
