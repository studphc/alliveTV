package p000;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NetworkTypeObserver;
import com.google.android.exoplayer2.util.Util;
import com.hisona.allive.PlayerActivity;
import java.util.concurrent.Executor;

/* renamed from: e9 */
/* loaded from: classes.dex */
public final class C1150e9 extends BroadcastReceiver {

    /* renamed from: a */
    public final /* synthetic */ int f16714a;

    /* renamed from: b */
    public final /* synthetic */ Object f16715b;

    public /* synthetic */ C1150e9(int i, Object obj) {
        this.f16714a = i;
        this.f16715b = obj;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Executor mainExecutor;
        int i = 0;
        Object obj = this.f16715b;
        switch (this.f16714a) {
            case 0:
                ((AbstractC1187f9) obj).mo4555d();
                return;
            case 1:
                if (!isInitialStickyBroadcast()) {
                    AudioCapabilities m2446b = AudioCapabilities.m2446b(context, intent);
                    AudioCapabilitiesReceiver audioCapabilitiesReceiver = (AudioCapabilitiesReceiver) obj;
                    if (audioCapabilitiesReceiver.f9653g && !m2446b.equals(audioCapabilitiesReceiver.f9652f)) {
                        audioCapabilitiesReceiver.f9652f = m2446b;
                        audioCapabilitiesReceiver.f9648b.onAudioCapabilitiesChanged(m2446b);
                        return;
                    }
                    return;
                }
                return;
            case 2:
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    try {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                            int type = activeNetworkInfo.getType();
                            if (type != 0) {
                                if (type != 1) {
                                    if (type != 4 && type != 5) {
                                        if (type != 6) {
                                            i = type != 9 ? 8 : 7;
                                        }
                                        i = 5;
                                    }
                                }
                                i = 2;
                            }
                            switch (activeNetworkInfo.getSubtype()) {
                                case 1:
                                case 2:
                                    i = 3;
                                    break;
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 14:
                                case 15:
                                case 17:
                                    i = 4;
                                    break;
                                case 13:
                                    i = 5;
                                    break;
                                case 16:
                                case 19:
                                default:
                                    i = 6;
                                    break;
                                case 18:
                                    i = 2;
                                    break;
                                case 20:
                                    if (Util.SDK_INT >= 29) {
                                        i = 9;
                                        break;
                                    }
                                    break;
                            }
                        } else {
                            i = 1;
                        }
                    } catch (SecurityException unused) {
                    }
                }
                NetworkTypeObserver networkTypeObserver = (NetworkTypeObserver) obj;
                if (Util.SDK_INT >= 31 && i == 5) {
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) Assertions.checkNotNull((TelephonyManager) context.getSystemService("phone"));
                        nr1 nr1Var = new nr1(networkTypeObserver);
                        mainExecutor = context.getMainExecutor();
                        telephonyManager.registerTelephonyCallback(mainExecutor, nr1Var);
                        telephonyManager.unregisterTelephonyCallback(nr1Var);
                        return;
                    } catch (RuntimeException unused2) {
                        NetworkTypeObserver.m3035a(networkTypeObserver, 5);
                        return;
                    }
                }
                NetworkTypeObserver.m3035a(networkTypeObserver, i);
                return;
            case 3:
                String action = intent.getAction();
                action.getClass();
                if (action.equals("android.media.action.HDMI_AUDIO_PLUG")) {
                    int intExtra = intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", -1);
                    boolean z = PlayerActivity.f15869d0;
                    Log.e("PlayerActivity", "ACTION_HDMI_AUDIO_PLUG " + intExtra);
                    if (intExtra == 0) {
                        ((PlayerActivity) obj).m4459f();
                        return;
                    }
                    return;
                }
                return;
            case 4:
                if (!isInitialStickyBroadcast()) {
                    ((RequirementsWatcher) obj).m2725a();
                    return;
                }
                return;
            case 5:
                try {
                    ((IntentSender) obj).sendIntent(context, 0, null, null, null);
                    return;
                } catch (IntentSender.SendIntentException unused3) {
                    return;
                }
            default:
                eo2 eo2Var = (eo2) obj;
                eo2Var.f16931b.post(new do2(i, eo2Var));
                return;
        }
    }
}
