package c.a.b.w;

import c.a.b.o;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public class f extends c.a.b.w.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f1246a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SSLSocketFactory f1247b = null;

    public static class a extends FilterInputStream {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HttpURLConnection f1248b;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(HttpURLConnection httpURLConnection) {
            InputStream errorStream;
            try {
                errorStream = httpURLConnection.getInputStream();
            } catch (IOException unused) {
                errorStream = httpURLConnection.getErrorStream();
            }
            super(errorStream);
            this.f1248b = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            this.f1248b.disconnect();
        }
    }

    public interface b {
        String a(String str);
    }

    public static void b(HttpURLConnection httpURLConnection, o<?> oVar, byte[] bArr) {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection.setRequestProperty("Content-Type", oVar.e());
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    public static List<c.a.b.h> c(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    arrayList.add(new c.a.b.h(entry.getKey(), it.next()));
                }
            }
        }
        return arrayList;
    }

    public static void d(HttpURLConnection httpURLConnection, o<?> oVar) throws ProtocolException {
        String str;
        switch (oVar.f1210c) {
            case -1:
                byte[] bArrH = oVar.h();
                if (bArrH != null) {
                    httpURLConnection.setRequestMethod("POST");
                    b(httpURLConnection, oVar, bArrH);
                    return;
                }
                return;
            case 0:
                str = "GET";
                break;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                byte[] bArrD = oVar.d();
                if (bArrD != null) {
                    b(httpURLConnection, oVar, bArrD);
                    return;
                }
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                byte[] bArrD2 = oVar.d();
                if (bArrD2 != null) {
                    b(httpURLConnection, oVar, bArrD2);
                    return;
                }
                return;
            case 3:
                str = "DELETE";
                break;
            case 4:
                str = "HEAD";
                break;
            case 5:
                str = "OPTIONS";
                break;
            case 6:
                str = "TRACE";
                break;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                byte[] bArrD3 = oVar.d();
                if (bArrD3 != null) {
                    b(httpURLConnection, oVar, bArrD3);
                    return;
                }
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
        httpURLConnection.setRequestMethod(str);
    }

    @Override // c.a.b.w.a
    public e a(o<?> oVar, Map<String, String> map) throws Throwable {
        SSLSocketFactory sSLSocketFactory;
        String str = oVar.d;
        HashMap map2 = new HashMap();
        map2.putAll(map);
        map2.putAll(oVar.g());
        b bVar = this.f1246a;
        if (bVar != null) {
            String strA = bVar.a(str);
            if (strA == null) {
                throw new IOException(c.a.a.a.a.c("URL blocked by rewriter: ", str));
            }
            str = strA;
        }
        URL url = new URL(str);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        int i = oVar.n.f1195a;
        httpURLConnection.setConnectTimeout(i);
        httpURLConnection.setReadTimeout(i);
        boolean z = false;
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.f1247b) != null) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
        }
        try {
            for (String str2 : map2.keySet()) {
                httpURLConnection.setRequestProperty(str2, (String) map2.get(str2));
            }
            d(httpURLConnection, oVar);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            if (!((oVar.f1210c == 4 || (100 <= responseCode && responseCode < 200) || responseCode == 204 || responseCode == 304) ? false : true)) {
                e eVar = new e(responseCode, c(httpURLConnection.getHeaderFields()));
                httpURLConnection.disconnect();
                return eVar;
            }
            try {
                return new e(responseCode, c(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new a(httpURLConnection));
            } catch (Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
