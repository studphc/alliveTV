package p000;

import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.net.HttpHeaders;

/* loaded from: classes.dex */
public abstract class fo1 {

    /* renamed from: a */
    public static final String[] f17354a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    /* renamed from: a */
    public static CommentFrame m4819a(int i, ParsableByteArray parsableByteArray) {
        int readInt = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            String readNullTerminatedString = parsableByteArray.readNullTerminatedString(readInt - 16);
            return new CommentFrame(C0643C.LANGUAGE_UNDETERMINED, readNullTerminatedString, readNullTerminatedString);
        }
        Log.m3027w("MetadataUtil", "Failed to parse comment attribute: " + AbstractC1386kc.m5517a(i));
        return null;
    }

    /* renamed from: b */
    public static ApicFrame m4820b(ParsableByteArray parsableByteArray) {
        String str;
        int readInt = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385) {
            int readInt2 = parsableByteArray.readInt() & ViewCompat.MEASURED_SIZE_MASK;
            if (readInt2 == 13) {
                str = MimeTypes.IMAGE_JPEG;
            } else if (readInt2 == 14) {
                str = "image/png";
            } else {
                str = null;
            }
            if (str == null) {
                AbstractC1726qj.m7036A(readInt2, "Unrecognized cover art flags: ", "MetadataUtil");
                return null;
            }
            parsableByteArray.skipBytes(4);
            int i = readInt - 16;
            byte[] bArr = new byte[i];
            parsableByteArray.readBytes(bArr, 0, i);
            return new ApicFrame(str, null, 3, bArr);
        }
        Log.m3027w("MetadataUtil", "Failed to parse cover art attribute");
        return null;
    }

    /* renamed from: c */
    public static TextInformationFrame m4821c(int i, ParsableByteArray parsableByteArray, String str) {
        int readInt = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385 && readInt >= 22) {
            parsableByteArray.skipBytes(10);
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            if (readUnsignedShort > 0) {
                String m8291k = ye0.m8291k(readUnsignedShort, "");
                int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
                if (readUnsignedShort2 > 0) {
                    m8291k = m8291k + "/" + readUnsignedShort2;
                }
                return new TextInformationFrame(str, null, m8291k);
            }
        }
        Log.m3027w("MetadataUtil", "Failed to parse index/count attribute: " + AbstractC1386kc.m5517a(i));
        return null;
    }

    /* renamed from: d */
    public static TextInformationFrame m4822d(int i, ParsableByteArray parsableByteArray, String str) {
        int readInt = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            return new TextInformationFrame(str, null, parsableByteArray.readNullTerminatedString(readInt - 16));
        }
        Log.m3027w("MetadataUtil", "Failed to parse text attribute: " + AbstractC1386kc.m5517a(i));
        return null;
    }

    /* renamed from: e */
    public static Id3Frame m4823e(int i, String str, ParsableByteArray parsableByteArray, boolean z, boolean z2) {
        int m4824f = m4824f(parsableByteArray);
        if (z2) {
            m4824f = Math.min(1, m4824f);
        }
        if (m4824f >= 0) {
            if (z) {
                return new TextInformationFrame(str, null, Integer.toString(m4824f));
            }
            return new CommentFrame(C0643C.LANGUAGE_UNDETERMINED, str, Integer.toString(m4824f));
        }
        Log.m3027w("MetadataUtil", "Failed to parse uint8 attribute: " + AbstractC1386kc.m5517a(i));
        return null;
    }

    /* renamed from: f */
    public static int m4824f(ParsableByteArray parsableByteArray) {
        parsableByteArray.skipBytes(4);
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            return parsableByteArray.readUnsignedByte();
        }
        Log.m3027w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
