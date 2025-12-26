package p000;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import androidx.core.app.NotificationManagerCompat;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class zs1 implements Handler.Callback, ServiceConnection {

    /* renamed from: a */
    public final Context f29509a;

    /* renamed from: b */
    public final Handler f29510b;

    /* renamed from: c */
    public final HashMap f29511c = new HashMap();

    /* renamed from: d */
    public Set f29512d = new HashSet();

    public zs1(Context context) {
        this.f29509a = context;
        HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
        handlerThread.start();
        this.f29510b = new Handler(handlerThread.getLooper(), this);
    }

    /* renamed from: a */
    public final void m8428a(ys1 ys1Var) {
        boolean z;
        ArrayDeque arrayDeque;
        boolean isLoggable = Log.isLoggable("NotifManCompat", 3);
        ComponentName componentName = ys1Var.f29122a;
        if (isLoggable) {
            Log.d("NotifManCompat", "Processing component " + componentName + ", " + ys1Var.f29125d.size() + " queued tasks");
        }
        if (ys1Var.f29125d.isEmpty()) {
            return;
        }
        if (ys1Var.f29123b) {
            z = true;
        } else {
            Intent component = new Intent(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL).setComponent(componentName);
            Context context = this.f29509a;
            boolean bindService = context.bindService(component, this, 33);
            ys1Var.f29123b = bindService;
            if (bindService) {
                ys1Var.f29126e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + componentName);
                context.unbindService(this);
            }
            z = ys1Var.f29123b;
        }
        if (z && ys1Var.f29124c != null) {
            while (true) {
                arrayDeque = ys1Var.f29125d;
                ws1 ws1Var = (ws1) arrayDeque.peek();
                if (ws1Var == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + ws1Var);
                    }
                    ys1Var.f29124c.notify(ws1Var.f28316a, ws1Var.f28317b, ws1Var.f28318c, ws1Var.f28319d);
                    arrayDeque.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + componentName);
                    }
                } catch (RemoteException e) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + componentName, e);
                }
            }
            if (!arrayDeque.isEmpty()) {
                m8429b(ys1Var);
                return;
            }
            return;
        }
        m8429b(ys1Var);
    }

    /* renamed from: b */
    public final void m8429b(ys1 ys1Var) {
        Handler handler = this.f29510b;
        ComponentName componentName = ys1Var.f29122a;
        if (handler.hasMessages(3, componentName)) {
            return;
        }
        int i = ys1Var.f29126e;
        int i2 = i + 1;
        ys1Var.f29126e = i2;
        if (i2 > 6) {
            StringBuilder sb = new StringBuilder("Giving up on delivering ");
            ArrayDeque arrayDeque = ys1Var.f29125d;
            sb.append(arrayDeque.size());
            sb.append(" tasks to ");
            sb.append(componentName);
            sb.append(" after ");
            sb.append(ys1Var.f29126e);
            sb.append(" retries");
            Log.w("NotifManCompat", sb.toString());
            arrayDeque.clear();
            return;
        }
        int i3 = (1 << i) * 1000;
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Scheduling retry for " + i3 + " ms");
        }
        handler.sendMessageDelayed(handler.obtainMessage(3, componentName), i3);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        HashMap hashMap = this.f29511c;
        Context context = this.f29509a;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    ys1 ys1Var = (ys1) hashMap.get((ComponentName) message.obj);
                    if (ys1Var != null) {
                        m8428a(ys1Var);
                    }
                    return true;
                }
                ys1 ys1Var2 = (ys1) hashMap.get((ComponentName) message.obj);
                if (ys1Var2 != null) {
                    if (ys1Var2.f29123b) {
                        context.unbindService(this);
                        ys1Var2.f29123b = false;
                    }
                    ys1Var2.f29124c = null;
                }
                return true;
            }
            xs1 xs1Var = (xs1) message.obj;
            ys1 ys1Var3 = (ys1) hashMap.get(xs1Var.f28725a);
            if (ys1Var3 != null) {
                ys1Var3.f29124c = INotificationSideChannel.Stub.asInterface(xs1Var.f28726b);
                ys1Var3.f29126e = 0;
                m8428a(ys1Var3);
            }
            return true;
        }
        ws1 ws1Var = (ws1) message.obj;
        Set<String> enabledListenerPackages = NotificationManagerCompat.getEnabledListenerPackages(context);
        if (!enabledListenerPackages.equals(this.f29512d)) {
            this.f29512d = enabledListenerPackages;
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent().setAction(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL), 0);
            HashSet hashSet = new HashSet();
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (enabledListenerPackages.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ComponentName componentName2 = (ComponentName) it.next();
                if (!hashMap.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    hashMap.put(componentName2, new ys1(componentName2));
                }
            }
            Iterator it2 = hashMap.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                if (!hashSet.contains(entry.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                    }
                    ys1 ys1Var4 = (ys1) entry.getValue();
                    if (ys1Var4.f29123b) {
                        context.unbindService(this);
                        ys1Var4.f29123b = false;
                    }
                    ys1Var4.f29124c = null;
                    it2.remove();
                }
            }
        }
        for (ys1 ys1Var5 : hashMap.values()) {
            ys1Var5.f29125d.add(ws1Var);
            m8428a(ys1Var5);
        }
        return true;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Connected to service " + componentName);
        }
        this.f29510b.obtainMessage(1, new xs1(componentName, iBinder)).sendToTarget();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Disconnected from service " + componentName);
        }
        this.f29510b.obtainMessage(2, componentName).sendToTarget();
    }
}
