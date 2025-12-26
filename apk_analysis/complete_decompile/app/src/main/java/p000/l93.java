package p000;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.exoplayer2.upstream.DataSchemeDataSource;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzfj;
import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzhi;
import com.google.android.gms.internal.measurement.zzhk;
import com.google.android.gms.internal.measurement.zzhm;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzic;
import com.google.android.gms.internal.measurement.zzie;
import com.google.android.gms.internal.measurement.zzpq;
import com.google.android.gms.measurement.internal.C0789b;
import com.google.android.gms.measurement.internal.C0820q0;
import com.google.android.gms.measurement.internal.C0822r0;
import com.google.android.gms.measurement.internal.zzgi;
import com.google.android.gms.measurement.internal.zzhc;
import com.google.android.gms.measurement.internal.zzhe;
import com.google.android.gms.measurement.internal.zzio;
import com.google.android.gms.measurement.internal.zzpv;
import com.google.android.gms.measurement.internal.zzqa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class l93 extends re3 {

    /* renamed from: b */
    public String f22419b;

    /* renamed from: c */
    public HashSet f22420c;

    /* renamed from: d */
    public ArrayMap f22421d;

    /* renamed from: e */
    public Long f22422e;

    /* renamed from: f */
    public Long f22423f;

    /* JADX WARN: Can't wrap try/catch for region: R(19:1|(2:2|(2:4|(2:6|7)(1:538))(2:539|540))|8|(3:10|11|12)|16|(1:537)(7:19|20|21|22|23|24|(13:(7:26|27|28|29|(1:31)(3:504|(2:506|507)(1:509)|508)|32|(1:35)(1:34))|36|37|38|39|40|41|(2:43|44)(3:462|(6:463|464|465|466|467|(1:470)(1:469))|471)|45|(1:47)(6:290|(12:292|293|294|295|296|(6:445|305|306|(3:401|(6:404|(2:440|441)(2:408|(8:414|415|(4:418|(2:420|421)(1:423)|422|416)|424|425|(4:428|(3:430|431|432)(1:434)|433|426)|435|436)(4:410|411|412|413))|437|438|413|402)|443)|308|309)|(4:298|(1:300)|301|302)|305|306|(0)|308|309)(1:461)|310|(10:313|(3:317|(4:320|(5:322|323|(1:325)(1:329)|326|327)(1:330)|328|318)|331)|332|(3:336|(4:339|(3:344|345|346)|347|337)|350)|351|(3:353|(6:356|(2:358|(3:360|361|362))(1:365)|363|364|362|354)|366)|367|(3:376|(8:379|(1:381)|382|(1:384)|385|(3:387|388|389)(1:391)|390|377)|392)|393|311)|399|400)|48|(3:50|(4:53|(3:55|56|(8:58|59|(7:61|62|63|64|65|(3:67|(11:68|69|70|71|72|73|74|(3:76|77|78)(1:132)|79|80|(1:83)(1:82))|84)(3:139|140|141)|85)(1:154)|86|(4:89|(3:111|112|113)(6:91|92|(2:93|(4:95|(1:97)(1:108)|98|(1:100)(2:101|102))(2:109|110))|(1:104)|105|106)|107|87)|114|115|116)(1:155))(1:156)|117|51)|157)|(6:159|(3:161|(6:164|(6:166|167|168|169|170|(3:(9:172|173|174|175|176|(1:178)(1:239)|179|180|(1:183)(1:182))|184|185)(4:246|247|238|185))(1:263)|186|(2:187|(2:189|(3:229|230|231)(8:191|(2:192|(4:194|(3:196|(1:198)(1:225)|199)(1:226)|200|(1:1)(4:204|(1:206)(1:217)|207|(1:209)(2:210|211)))(2:227|228))|219|(1:221)(1:223)|222|213|214|215))(0))|232|162)|264)|265|(9:268|269|270|271|272|273|(2:275|276)(1:278)|277|266)|286|287)(2:288|289))(3:515|516|517))|518|37|38|39|40|41|(0)(0)|45|(0)(0)|48|(0)|(0)(0)|(4:(0)|(0)|(0)|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x09ec, code lost:
    
        if (r8 != false) goto L507;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x08b7, code lost:
    
        if (r10 == null) goto L370;
     */
    /* JADX WARN: Code restructure failed: missing block: B:449:0x0309, code lost:
    
        if (r5 == null) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:496:0x01d0, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:497:0x01d1, code lost:
    
        r38 = "audience_id";
     */
    /* JADX WARN: Code restructure failed: missing block: B:499:0x023f, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:500:0x0240, code lost:
    
        r38 = "audience_id";
        r19 = "Database error querying filters. appId";
     */
    /* JADX WARN: Code restructure failed: missing block: B:501:0x0248, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:502:0x023d, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:503:0x0245, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:522:0x0185, code lost:
    
        if (r12 == null) goto L50;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:125:0x06ee  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x06f8  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x07c7  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0a9e  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01c2 A[Catch: SQLiteException -> 0x01d0, all -> 0x0206, TRY_LEAVE, TryCatch #16 {all -> 0x0206, blocks: (B:41:0x01bc, B:43:0x01c2, B:462:0x01d7, B:463:0x01dc, B:465:0x01e6, B:466:0x01f6, B:467:0x0226, B:481:0x0209, B:484:0x0215, B:487:0x021f, B:474:0x0249), top: B:40:0x01bc }] */
    /* JADX WARN: Removed duplicated region for block: B:455:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x01d7 A[Catch: SQLiteException -> 0x01d0, all -> 0x0206, TRY_ENTER, TryCatch #16 {all -> 0x0206, blocks: (B:41:0x01bc, B:43:0x01c2, B:462:0x01d7, B:463:0x01dc, B:465:0x01e6, B:466:0x01f6, B:467:0x0226, B:481:0x0209, B:484:0x0215, B:487:0x021f, B:474:0x0249), top: B:40:0x01bc }] */
    /* JADX WARN: Removed duplicated region for block: B:476:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x05d5  */
    /* JADX WARN: Removed duplicated region for block: B:530:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x070e  */
    /* JADX WARN: Type inference failed for: r37v22 */
    /* JADX WARN: Type inference failed for: r37v23 */
    /* JADX WARN: Type inference failed for: r37v25 */
    /* JADX WARN: Type inference failed for: r37v40 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ArrayList m5910a(String str, List list, List list2, Long l, Long l2, boolean z) {
        int i;
        boolean z2;
        String str2;
        Map map;
        String str3;
        Cursor cursor;
        String str4;
        String str5;
        Map map2;
        String str6;
        Map map3;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        List<zzfj> list3;
        String str12;
        ?? r4;
        Cursor cursor2;
        Map map4;
        Iterator it;
        String str13;
        Iterator it2;
        Map map5;
        ArrayMap arrayMap;
        zzfr zzfrVar;
        zzio zzioVar;
        Integer num;
        Cursor cursor3;
        Cursor cursor4;
        List list4;
        da3 da3Var;
        C0822r0 c0822r0;
        Iterator it3;
        Iterator it4;
        da3 da3Var2;
        Map map6;
        Integer num2;
        Cursor cursor5;
        List list5;
        ArrayMap arrayMap2;
        Cursor cursor6;
        ?? r37;
        Cursor cursor7;
        String str14;
        String str15;
        String str16;
        List list6;
        String str17 = "current_results";
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.f22419b = str;
        this.f22420c = new HashSet();
        this.f22421d = new ArrayMap();
        this.f22422e = l;
        this.f22423f = l2;
        Iterator it5 = list.iterator();
        while (true) {
            i = 1;
            if (!it5.hasNext()) {
                z2 = false;
                break;
            }
            if ("_s".equals(((zzhm) it5.next()).zzh())) {
                z2 = true;
                break;
            }
        }
        zzpq.zzb();
        zzio zzioVar2 = this.zzu;
        boolean zzx = zzioVar2.zzf().zzx(this.f22419b, zzgi.zzaE);
        zzpq.zzb();
        boolean zzx2 = zzioVar2.zzf().zzx(this.f22419b, zzgi.zzaD);
        if (z2) {
            v93 zzj = this.zzg.zzj();
            String str18 = this.f22419b;
            zzj.zzav();
            zzj.zzg();
            Preconditions.checkNotEmpty(str18);
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_session_count", (Integer) 0);
            try {
                zzj.m7841Q().update("events", contentValues, "app_id = ?", new String[]{str18});
            } catch (SQLiteException e) {
                zzj.zzu.zzaW().zze().zzc("Error resetting session-scoped event counts. appId", zzhe.zzn(str18), e);
            }
        }
        Map emptyMap = Collections.emptyMap();
        String str19 = "Failed to merge filter. appId";
        String str20 = "Database error querying filters. appId";
        String str21 = DataSchemeDataSource.SCHEME_DATA;
        String str22 = "audience_id";
        try {
            if (zzx2 && zzx) {
                v93 zzj2 = this.zzg.zzj();
                String str23 = this.f22419b;
                Preconditions.checkNotEmpty(str23);
                ArrayMap arrayMap3 = new ArrayMap();
                try {
                    try {
                        cursor7 = zzj2.m7841Q().query("event_filters", new String[]{"audience_id", DataSchemeDataSource.SCHEME_DATA}, "app_id=?", new String[]{str23}, null, null, null);
                        try {
                            try {
                            } catch (SQLiteException e2) {
                                e = e2;
                                r37 = l;
                                zzj2.zzu.zzaW().zze().zzc("Database error querying filters. appId", zzhe.zzn(str23), e);
                                emptyMap = Collections.emptyMap();
                                str14 = r37;
                                str2 = r37;
                            }
                        } catch (SQLiteException e3) {
                            e = e3;
                            r37 = str21;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor6 = null;
                        if (cursor6 != null) {
                            cursor6.close();
                        }
                        throw th;
                    }
                } catch (SQLiteException e4) {
                    e = e4;
                    r37 = DataSchemeDataSource.SCHEME_DATA;
                    cursor7 = null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor6 = null;
                    if (cursor6 != null) {
                    }
                    throw th;
                }
                if (cursor7.moveToFirst()) {
                    while (true) {
                        try {
                            zzfj zzfjVar = (zzfj) ((zzfi) zzqa.m3683x(zzfj.zzc(), cursor7.getBlob(i))).zzba();
                            if (zzfjVar.zzo()) {
                                Integer valueOf = Integer.valueOf(cursor7.getInt(0));
                                List list7 = (List) arrayMap3.get(valueOf);
                                if (list7 == null) {
                                    str16 = str21;
                                    list6 = new ArrayList();
                                    arrayMap3.put(valueOf, list6);
                                } else {
                                    str16 = str21;
                                    list6 = list7;
                                }
                                list6.add(zzfjVar);
                                str15 = str16;
                            } else {
                                str15 = str21;
                            }
                        } catch (IOException e5) {
                            str15 = str21;
                            zzj2.zzu.zzaW().zze().zzc("Failed to merge filter. appId", zzhe.zzn(str23), e5);
                        }
                        if (!cursor7.moveToNext()) {
                            break;
                        }
                        str21 = str15;
                        i = 1;
                    }
                    cursor7.close();
                    map = arrayMap3;
                    str3 = str15;
                    v93 zzj3 = this.zzg.zzj();
                    String str24 = this.f22419b;
                    zzj3.zzav();
                    zzj3.zzg();
                    Preconditions.checkNotEmpty(str24);
                    cursor = zzj3.m7841Q().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str24}, null, null, null);
                    if (cursor.moveToFirst()) {
                        Map emptyMap2 = Collections.emptyMap();
                        cursor.close();
                        map2 = emptyMap2;
                        str4 = "audience_id";
                        str5 = "Database error querying filters. appId";
                    } else {
                        ArrayMap arrayMap4 = new ArrayMap();
                        while (true) {
                            int i2 = cursor.getInt(0);
                            try {
                                arrayMap4.put(Integer.valueOf(i2), (zzic) ((zzib) zzqa.m3683x(zzic.zze(), cursor.getBlob(1))).zzba());
                                str4 = str22;
                                arrayMap2 = arrayMap4;
                                str5 = str20;
                            } catch (IOException e6) {
                                str4 = str22;
                                try {
                                    arrayMap2 = arrayMap4;
                                    str5 = str20;
                                    try {
                                        zzj3.zzu.zzaW().zze().zzd("Failed to merge filter results. appId, audienceId, error", zzhe.zzn(str24), Integer.valueOf(i2), e6);
                                    } catch (SQLiteException e7) {
                                        e = e7;
                                        zzj3.zzu.zzaW().zze().zzc("Database error querying filter results. appId", zzhe.zzn(str24), e);
                                        Map emptyMap3 = Collections.emptyMap();
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        map2 = emptyMap3;
                                        if (!map2.isEmpty()) {
                                        }
                                        if (!list.isEmpty()) {
                                        }
                                        if (z) {
                                        }
                                    }
                                } catch (SQLiteException e8) {
                                    e = e8;
                                    str5 = str20;
                                    zzj3.zzu.zzaW().zze().zzc("Database error querying filter results. appId", zzhe.zzn(str24), e);
                                    Map emptyMap32 = Collections.emptyMap();
                                    if (cursor != null) {
                                    }
                                    map2 = emptyMap32;
                                    if (!map2.isEmpty()) {
                                    }
                                    if (!list.isEmpty()) {
                                    }
                                    if (z) {
                                    }
                                }
                            }
                            if (!cursor.moveToNext()) {
                                break;
                            }
                            str22 = str4;
                            arrayMap4 = arrayMap2;
                            str20 = str5;
                        }
                        cursor.close();
                        map2 = arrayMap2;
                    }
                    if (!map2.isEmpty()) {
                        str7 = str3;
                        str8 = str4;
                        str11 = "Failed to merge filter. appId";
                        str9 = "current_results";
                        str10 = str5;
                    } else {
                        HashSet hashSet = new HashSet(map2.keySet());
                        if (z2) {
                            String str25 = this.f22419b;
                            v93 zzj4 = this.zzg.zzj();
                            String str26 = this.f22419b;
                            zzj4.zzav();
                            zzj4.zzg();
                            Preconditions.checkNotEmpty(str26);
                            Map arrayMap5 = new ArrayMap();
                            SQLiteDatabase m7841Q = zzj4.m7841Q();
                            try {
                                try {
                                    cursor2 = m7841Q.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str26, str26});
                                    try {
                                    } catch (SQLiteException e9) {
                                        e = e9;
                                        zzj4.zzu.zzaW().zze().zzc("Database error querying scoped filters. appId", zzhe.zzn(str26), e);
                                        arrayMap5 = Collections.emptyMap();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    r4 = m7841Q;
                                    if (r4 != 0) {
                                        r4.close();
                                    }
                                    throw th;
                                }
                            } catch (SQLiteException e10) {
                                e = e10;
                                cursor2 = null;
                            } catch (Throwable th4) {
                                th = th4;
                                r4 = 0;
                                if (r4 != 0) {
                                }
                                throw th;
                            }
                            if (!cursor2.moveToFirst()) {
                                arrayMap5 = Collections.emptyMap();
                                cursor2.close();
                                Preconditions.checkNotEmpty(str25);
                                Preconditions.checkNotNull(map2);
                                ArrayMap arrayMap6 = new ArrayMap();
                                if (!map2.isEmpty()) {
                                    Iterator it6 = map2.keySet().iterator();
                                    while (it6.hasNext()) {
                                        Integer num3 = (Integer) it6.next();
                                        num3.getClass();
                                        zzic zzicVar = (zzic) map2.get(num3);
                                        List list8 = (List) arrayMap5.get(num3);
                                        if (list8 != null && !list8.isEmpty()) {
                                            zzpv zzpvVar = this.zzg;
                                            map4 = arrayMap5;
                                            it = it6;
                                            List m3684A = zzpvVar.zzA().m3684A(zzicVar.zzi(), list8);
                                            if (m3684A.isEmpty()) {
                                                arrayMap5 = map4;
                                                it6 = it;
                                            } else {
                                                zzib zzibVar = (zzib) zzicVar.zzch();
                                                zzibVar.zzf();
                                                zzibVar.zzb(m3684A);
                                                List m3684A2 = zzpvVar.zzA().m3684A(zzicVar.zzk(), list8);
                                                zzibVar.zzh();
                                                zzibVar.zzd(m3684A2);
                                                ArrayList arrayList = new ArrayList();
                                                Iterator it7 = zzicVar.zzh().iterator();
                                                while (it7.hasNext()) {
                                                    Iterator it8 = it7;
                                                    zzhk zzhkVar = (zzhk) it7.next();
                                                    String str27 = str19;
                                                    if (!list8.contains(Integer.valueOf(zzhkVar.zza()))) {
                                                        arrayList.add(zzhkVar);
                                                    }
                                                    it7 = it8;
                                                    str19 = str27;
                                                }
                                                str13 = str19;
                                                zzibVar.zze();
                                                zzibVar.zza(arrayList);
                                                ArrayList arrayList2 = new ArrayList();
                                                for (zzie zzieVar : zzicVar.zzj()) {
                                                    if (!list8.contains(Integer.valueOf(zzieVar.zzb()))) {
                                                        arrayList2.add(zzieVar);
                                                    }
                                                }
                                                zzibVar.zzg();
                                                zzibVar.zzc(arrayList2);
                                                arrayMap6.put(num3, (zzic) zzibVar.zzba());
                                            }
                                        } else {
                                            map4 = arrayMap5;
                                            it = it6;
                                            str13 = str19;
                                            arrayMap6.put(num3, zzicVar);
                                        }
                                        arrayMap5 = map4;
                                        it6 = it;
                                        str19 = str13;
                                    }
                                }
                                str6 = str19;
                                map3 = arrayMap6;
                            }
                            do {
                                Integer valueOf2 = Integer.valueOf(cursor2.getInt(0));
                                List list9 = (List) arrayMap5.get(valueOf2);
                                if (list9 == null) {
                                    list9 = new ArrayList();
                                    arrayMap5.put(valueOf2, list9);
                                }
                                list9.add(Integer.valueOf(cursor2.getInt(1)));
                            } while (cursor2.moveToNext());
                            cursor2.close();
                            Preconditions.checkNotEmpty(str25);
                            Preconditions.checkNotNull(map2);
                            ArrayMap arrayMap62 = new ArrayMap();
                            if (!map2.isEmpty()) {
                            }
                            str6 = str19;
                            map3 = arrayMap62;
                        } else {
                            str6 = "Failed to merge filter. appId";
                            map3 = map2;
                        }
                        Iterator it9 = hashSet.iterator();
                        String str28 = str3;
                        while (it9.hasNext()) {
                            Integer num4 = (Integer) it9.next();
                            num4.getClass();
                            zzic zzicVar2 = (zzic) map3.get(num4);
                            BitSet bitSet = new BitSet();
                            BitSet bitSet2 = new BitSet();
                            ArrayMap arrayMap7 = new ArrayMap();
                            if (zzicVar2 != null && zzicVar2.zza() != 0) {
                                for (zzhk zzhkVar2 : zzicVar2.zzh()) {
                                    if (zzhkVar2.zzh()) {
                                        arrayMap7.put(Integer.valueOf(zzhkVar2.zza()), zzhkVar2.zzg() ? Long.valueOf(zzhkVar2.zzb()) : null);
                                    }
                                }
                            }
                            ArrayMap arrayMap8 = new ArrayMap();
                            if (zzicVar2 != null && zzicVar2.zzc() != 0) {
                                Iterator it10 = zzicVar2.zzj().iterator();
                                while (it10.hasNext()) {
                                    zzie zzieVar2 = (zzie) it10.next();
                                    if (zzieVar2.zzi() && zzieVar2.zza() > 0) {
                                        arrayMap8.put(Integer.valueOf(zzieVar2.zzb()), Long.valueOf(zzieVar2.zzc(zzieVar2.zza() - 1)));
                                        map3 = map3;
                                        it10 = it10;
                                    }
                                }
                            }
                            Map map7 = map3;
                            if (zzicVar2 != null) {
                                int i3 = 0;
                                while (i3 < zzicVar2.zzd() * 64) {
                                    if (zzqa.m3666F(i3, zzicVar2.zzk())) {
                                        str12 = str17;
                                        this.zzu.zzaW().zzj().zzc("Filter already evaluated. audience ID, filter ID", num4, Integer.valueOf(i3));
                                        bitSet2.set(i3);
                                        if (zzqa.m3666F(i3, zzicVar2.zzi())) {
                                            bitSet.set(i3);
                                            i3++;
                                            str17 = str12;
                                        }
                                    } else {
                                        str12 = str17;
                                    }
                                    arrayMap7.remove(Integer.valueOf(i3));
                                    i3++;
                                    str17 = str12;
                                }
                            }
                            String str29 = str17;
                            zzic zzicVar3 = (zzic) map2.get(num4);
                            if (zzx2 && zzx && (list3 = (List) map.get(num4)) != null && this.f22423f != null && this.f22422e != null) {
                                for (zzfj zzfjVar2 : list3) {
                                    int zzb = zzfjVar2.zzb();
                                    long longValue = this.f22423f.longValue() / 1000;
                                    if (zzfjVar2.zzm()) {
                                        longValue = this.f22422e.longValue() / 1000;
                                    }
                                    Integer valueOf3 = Integer.valueOf(zzb);
                                    if (arrayMap7.containsKey(valueOf3)) {
                                        arrayMap7.put(valueOf3, Long.valueOf(longValue));
                                    }
                                    if (arrayMap8.containsKey(valueOf3)) {
                                        arrayMap8.put(valueOf3, Long.valueOf(longValue));
                                    }
                                }
                            }
                            this.f22421d.put(num4, new C0820q0(this, this.f22419b, zzicVar3, bitSet, bitSet2, arrayMap7, arrayMap8));
                            str17 = str29;
                            map3 = map7;
                            zzx = zzx;
                            zzx2 = zzx2;
                            str4 = str4;
                            str28 = str28;
                            map = map;
                            map2 = map2;
                        }
                        str7 = str28;
                        str8 = str4;
                        str9 = str17;
                        str10 = str5;
                        str11 = str6;
                    }
                    if (!list.isEmpty()) {
                        C0822r0 c0822r02 = new C0822r0(this);
                        ArrayMap arrayMap9 = new ArrayMap();
                        Iterator it11 = list.iterator();
                        while (it11.hasNext()) {
                            zzhm zzhmVar = (zzhm) it11.next();
                            zzhm m3504a = c0822r02.m3504a(zzhmVar, this.f22419b);
                            if (m3504a != null) {
                                zzpv zzpvVar2 = this.zzg;
                                da3 m7847W = zzpvVar2.zzj().m7847W(this.f22419b, zzhmVar, m3504a.zzh());
                                zzpvVar2.zzj().m7828B("events", m7847W);
                                if (z) {
                                    continue;
                                } else {
                                    String zzh = m3504a.zzh();
                                    Map map8 = (Map) arrayMap9.get(zzh);
                                    if (map8 == null) {
                                        v93 zzj5 = zzpvVar2.zzj();
                                        String str30 = this.f22419b;
                                        zzj5.zzav();
                                        zzj5.zzg();
                                        Preconditions.checkNotEmpty(str30);
                                        Preconditions.checkNotEmpty(zzh);
                                        ArrayMap arrayMap10 = new ArrayMap();
                                        try {
                                            Cursor query = zzj5.m7841Q().query("event_filters", new String[]{str8, str7}, "app_id=? AND event_name=?", new String[]{str30, zzh}, null, null, null);
                                            try {
                                                try {
                                                    if (query.moveToFirst()) {
                                                        da3Var = m7847W;
                                                        while (true) {
                                                            try {
                                                                try {
                                                                    zzfj zzfjVar3 = (zzfj) ((zzfi) zzqa.m3683x(zzfj.zzc(), query.getBlob(1))).zzba();
                                                                    Integer valueOf4 = Integer.valueOf(query.getInt(0));
                                                                    List list10 = (List) arrayMap10.get(valueOf4);
                                                                    if (list10 == null) {
                                                                        c0822r0 = c0822r02;
                                                                        try {
                                                                            list5 = new ArrayList();
                                                                            arrayMap10.put(valueOf4, list5);
                                                                        } catch (SQLiteException e11) {
                                                                            e = e11;
                                                                            cursor5 = query;
                                                                            try {
                                                                                zzj5.zzu.zzaW().zze().zzc(str10, zzhe.zzn(str30), e);
                                                                                map8 = Collections.emptyMap();
                                                                                if (cursor5 != null) {
                                                                                    cursor5.close();
                                                                                }
                                                                                arrayMap9.put(zzh, map8);
                                                                                it3 = map8.keySet().iterator();
                                                                                while (it3.hasNext()) {
                                                                                }
                                                                                c0822r02 = c0822r0;
                                                                            } catch (Throwable th5) {
                                                                                th = th5;
                                                                                if (cursor5 != null) {
                                                                                    cursor5.close();
                                                                                }
                                                                                throw th;
                                                                            }
                                                                        }
                                                                    } else {
                                                                        c0822r0 = c0822r02;
                                                                        list5 = list10;
                                                                    }
                                                                    list5.add(zzfjVar3);
                                                                } catch (IOException e12) {
                                                                    c0822r0 = c0822r02;
                                                                    zzj5.zzu.zzaW().zze().zzc(str11, zzhe.zzn(str30), e12);
                                                                }
                                                                if (!query.moveToNext()) {
                                                                    break;
                                                                }
                                                                c0822r02 = c0822r0;
                                                            } catch (SQLiteException e13) {
                                                                e = e13;
                                                                c0822r0 = c0822r02;
                                                                cursor5 = query;
                                                                zzj5.zzu.zzaW().zze().zzc(str10, zzhe.zzn(str30), e);
                                                                map8 = Collections.emptyMap();
                                                                if (cursor5 != null) {
                                                                }
                                                                arrayMap9.put(zzh, map8);
                                                                it3 = map8.keySet().iterator();
                                                                while (it3.hasNext()) {
                                                                }
                                                                c0822r02 = c0822r0;
                                                            }
                                                        }
                                                        query.close();
                                                        map8 = arrayMap10;
                                                    } else {
                                                        da3Var = m7847W;
                                                        c0822r0 = c0822r02;
                                                        map8 = Collections.emptyMap();
                                                        query.close();
                                                    }
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    cursor5 = query;
                                                    if (cursor5 != null) {
                                                    }
                                                    throw th;
                                                }
                                            } catch (SQLiteException e14) {
                                                e = e14;
                                                da3Var = m7847W;
                                            }
                                        } catch (SQLiteException e15) {
                                            e = e15;
                                            da3Var = m7847W;
                                            c0822r0 = c0822r02;
                                            cursor5 = null;
                                        } catch (Throwable th7) {
                                            th = th7;
                                            cursor5 = null;
                                        }
                                        arrayMap9.put(zzh, map8);
                                    } else {
                                        da3Var = m7847W;
                                        c0822r0 = c0822r02;
                                    }
                                    it3 = map8.keySet().iterator();
                                    while (it3.hasNext()) {
                                        Integer num5 = (Integer) it3.next();
                                        int intValue = num5.intValue();
                                        if (this.f22420c.contains(num5)) {
                                            this.zzu.zzaW().zzj().zzb("Skipping failed audience ID", num5);
                                        } else {
                                            Iterator it12 = ((List) map8.get(num5)).iterator();
                                            boolean z3 = true;
                                            while (true) {
                                                if (!it12.hasNext()) {
                                                    it4 = it3;
                                                    da3Var2 = da3Var;
                                                    map6 = map8;
                                                    num2 = num5;
                                                    break;
                                                }
                                                zzfj zzfjVar4 = (zzfj) it12.next();
                                                it4 = it3;
                                                da3Var2 = da3Var;
                                                map6 = map8;
                                                num2 = num5;
                                                C0789b c0789b = new C0789b(this, this.f22419b, intValue, zzfjVar4, 0);
                                                Long l3 = this.f22422e;
                                                Long l4 = this.f22423f;
                                                int zzb2 = zzfjVar4.zzb();
                                                C0820q0 c0820q0 = (C0820q0) this.f22421d.get(num2);
                                                z3 = c0789b.m3487a(l3, l4, m3504a, da3Var2.f16316c, da3Var2, c0820q0 == null ? false : c0820q0.f14077d.get(zzb2));
                                                if (z3) {
                                                    m5911b(num2).m3503b(c0789b);
                                                    num5 = num2;
                                                    map8 = map6;
                                                    da3Var = da3Var2;
                                                    it3 = it4;
                                                } else {
                                                    this.f22420c.add(num2);
                                                    break;
                                                }
                                            }
                                            if (!z3) {
                                                this.f22420c.add(num2);
                                            }
                                            map8 = map6;
                                            da3Var = da3Var2;
                                            it3 = it4;
                                        }
                                    }
                                    c0822r02 = c0822r0;
                                }
                            }
                        }
                    }
                    if (z) {
                        if (!list2.isEmpty()) {
                            ArrayMap arrayMap11 = new ArrayMap();
                            Iterator it13 = list2.iterator();
                            while (it13.hasNext()) {
                                com.google.android.gms.internal.measurement.zzio zzioVar3 = (com.google.android.gms.internal.measurement.zzio) it13.next();
                                String zzg = zzioVar3.zzg();
                                Map map9 = (Map) arrayMap11.get(zzg);
                                if (map9 == null) {
                                    v93 zzj6 = this.zzg.zzj();
                                    String str31 = this.f22419b;
                                    zzj6.zzav();
                                    zzj6.zzg();
                                    Preconditions.checkNotEmpty(str31);
                                    Preconditions.checkNotEmpty(zzg);
                                    ArrayMap arrayMap12 = new ArrayMap();
                                    try {
                                        cursor4 = zzj6.m7841Q().query("property_filters", new String[]{str8, str7}, "app_id=? AND property_name=?", new String[]{str31, zzg}, null, null, null);
                                        try {
                                            try {
                                            } catch (SQLiteException e16) {
                                                e = e16;
                                                it2 = it13;
                                            }
                                        } catch (Throwable th8) {
                                            th = th8;
                                            cursor3 = cursor4;
                                            if (cursor3 != null) {
                                                cursor3.close();
                                            }
                                            throw th;
                                        }
                                    } catch (SQLiteException e17) {
                                        e = e17;
                                        it2 = it13;
                                        cursor4 = null;
                                    } catch (Throwable th9) {
                                        th = th9;
                                        cursor3 = null;
                                    }
                                    if (cursor4.moveToFirst()) {
                                        while (true) {
                                            try {
                                                zzfr zzfrVar2 = (zzfr) ((zzfq) zzqa.m3683x(zzfr.zzc(), cursor4.getBlob(1))).zzba();
                                                Integer valueOf5 = Integer.valueOf(cursor4.getInt(0));
                                                List list11 = (List) arrayMap12.get(valueOf5);
                                                if (list11 == null) {
                                                    list4 = new ArrayList();
                                                    arrayMap12.put(valueOf5, list4);
                                                } else {
                                                    list4 = list11;
                                                }
                                                list4.add(zzfrVar2);
                                                it2 = it13;
                                            } catch (IOException e18) {
                                                it2 = it13;
                                                try {
                                                    zzj6.zzu.zzaW().zze().zzc("Failed to merge filter", zzhe.zzn(str31), e18);
                                                } catch (SQLiteException e19) {
                                                    e = e19;
                                                    zzj6.zzu.zzaW().zze().zzc(str10, zzhe.zzn(str31), e);
                                                    map9 = Collections.emptyMap();
                                                }
                                            }
                                            if (!cursor4.moveToNext()) {
                                                break;
                                            }
                                            it13 = it2;
                                        }
                                        cursor4.close();
                                        map9 = arrayMap12;
                                        arrayMap11.put(zzg, map9);
                                    } else {
                                        it2 = it13;
                                        map9 = Collections.emptyMap();
                                        cursor4.close();
                                        arrayMap11.put(zzg, map9);
                                    }
                                } else {
                                    it2 = it13;
                                }
                                Iterator it14 = map9.keySet().iterator();
                                while (true) {
                                    if (it14.hasNext()) {
                                        Integer num6 = (Integer) it14.next();
                                        int intValue2 = num6.intValue();
                                        if (this.f22420c.contains(num6)) {
                                            this.zzu.zzaW().zzj().zzb("Skipping failed audience ID", num6);
                                            break;
                                        }
                                        Iterator it15 = ((List) map9.get(num6)).iterator();
                                        boolean z4 = true;
                                        while (true) {
                                            if (!it15.hasNext()) {
                                                map5 = map9;
                                                arrayMap = arrayMap11;
                                                break;
                                            }
                                            zzfrVar = (zzfr) it15.next();
                                            zzioVar = this.zzu;
                                            if (Log.isLoggable(zzioVar.zzaW().zzr(), 2)) {
                                                zzhc zzj7 = zzioVar.zzaW().zzj();
                                                if (zzfrVar.zzj()) {
                                                    num = Integer.valueOf(zzfrVar.zza());
                                                    map5 = map9;
                                                } else {
                                                    map5 = map9;
                                                    num = null;
                                                }
                                                arrayMap = arrayMap11;
                                                zzj7.zzd("Evaluating filter. audience, filter, property", num6, num, zzioVar.zzj().zzf(zzfrVar.zze()));
                                                zzioVar.zzaW().zzj().zzb("Filter definition", this.zzg.zzA().m3696z(zzfrVar));
                                            } else {
                                                map5 = map9;
                                                arrayMap = arrayMap11;
                                            }
                                            if (!zzfrVar.zzj() || zzfrVar.zza() > 256) {
                                                break;
                                            }
                                            C0789b c0789b2 = new C0789b(this, this.f22419b, intValue2, zzfrVar, 1);
                                            Long l5 = this.f22422e;
                                            Long l6 = this.f22423f;
                                            int zza = zzfrVar.zza();
                                            C0820q0 c0820q02 = (C0820q0) this.f22421d.get(num6);
                                            z4 = c0789b2.m3488b(l5, l6, zzioVar3, c0820q02 == null ? false : c0820q02.f14077d.get(zza));
                                            if (z4) {
                                                m5911b(num6).m3503b(c0789b2);
                                                map9 = map5;
                                                arrayMap11 = arrayMap;
                                            } else {
                                                this.f22420c.add(num6);
                                                break;
                                            }
                                        }
                                        zzioVar.zzaW().zzk().zzc("Invalid property filter ID. appId, id", zzhe.zzn(this.f22419b), String.valueOf(zzfrVar.zzj() ? Integer.valueOf(zzfrVar.zza()) : null));
                                        this.f22420c.add(num6);
                                        map9 = map5;
                                        arrayMap11 = arrayMap;
                                    }
                                }
                                it13 = it2;
                            }
                        }
                        ArrayList arrayList3 = new ArrayList();
                        Set<Integer> keySet = this.f22421d.keySet();
                        keySet.removeAll(this.f22420c);
                        for (Integer num7 : keySet) {
                            int intValue3 = num7.intValue();
                            C0820q0 c0820q03 = (C0820q0) this.f22421d.get(num7);
                            Preconditions.checkNotNull(c0820q03);
                            zzhi m3502a = c0820q03.m3502a(intValue3);
                            arrayList3.add(m3502a);
                            v93 zzj8 = this.zzg.zzj();
                            String str32 = this.f22419b;
                            zzic zzd = m3502a.zzd();
                            zzj8.zzav();
                            zzj8.zzg();
                            Preconditions.checkNotEmpty(str32);
                            Preconditions.checkNotNull(zzd);
                            byte[] zzcd = zzd.zzcd();
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("app_id", str32);
                            contentValues2.put(str8, num7);
                            String str33 = str9;
                            contentValues2.put(str33, zzcd);
                            try {
                            } catch (SQLiteException e20) {
                                e = e20;
                            }
                            try {
                                if (zzj8.m7841Q().insertWithOnConflict("audience_filter_values", null, contentValues2, 5) == -1) {
                                    zzj8.zzu.zzaW().zze().zzb("Failed to insert filter results (got -1). appId", zzhe.zzn(str32));
                                }
                            } catch (SQLiteException e21) {
                                e = e21;
                                zzj8.zzu.zzaW().zze().zzc("Error storing filter results. appId", zzhe.zzn(str32), e);
                                str9 = str33;
                            }
                            str9 = str33;
                        }
                        return arrayList3;
                    }
                    return new ArrayList();
                }
                str14 = DataSchemeDataSource.SCHEME_DATA;
                emptyMap = Collections.emptyMap();
                cursor7.close();
                str2 = str14;
            } else {
                str2 = DataSchemeDataSource.SCHEME_DATA;
            }
            if (cursor.moveToFirst()) {
            }
            if (!map2.isEmpty()) {
            }
            if (!list.isEmpty()) {
            }
            if (z) {
            }
        } catch (Throwable th10) {
            th = th10;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        map = emptyMap;
        str3 = str2;
        v93 zzj32 = this.zzg.zzj();
        String str242 = this.f22419b;
        zzj32.zzav();
        zzj32.zzg();
        Preconditions.checkNotEmpty(str242);
        cursor = zzj32.m7841Q().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str242}, null, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public final C0820q0 m5911b(Integer num) {
        if (this.f22421d.containsKey(num)) {
            return (C0820q0) this.f22421d.get(num);
        }
        C0820q0 c0820q0 = new C0820q0(this, this.f22419b);
        this.f22421d.put(num, c0820q0);
        return c0820q0;
    }

    @Override // p000.re3
    public final boolean zzb() {
        return false;
    }
}
