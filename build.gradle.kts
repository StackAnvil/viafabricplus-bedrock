plugins {
    id("base.java")
    id("base.fabric")
    id("configuration.transitive_jar_in_jar")
    id("via.maven_publish")
}

dependencies {
    implementation(libs.viafabricplus)

    jarInJar(libs.viabedrock) {
        exclude(group = "com.mojang", module = "brigadier")
        exclude(group = "at.yawk.lz4", module = "lz4-java")
        exclude(group = "io.netty")
    }
    jarInJar(libs.minecraftauth) {
        exclude(group = "com.google.code.gson", module = "gson")
    }
    jarInJar(libs.netty.transport.raknet) {
        exclude(group = "io.netty")
    }
    jarInJar(libs.netty.transport.nethernet) {
        exclude(group = "io.netty")
        exclude(group = "org.bouncycastle")
        exclude(group = "dev.opencollab", module = "libdatachannel-java")
    }
    jarInJar(libs.libdatachannel.java.arch.detect)
    jarInJar("com.microsoft.signalr.messagepack:signalr-messagepack:9.0.4")
    // SignalR still requests MessagePack 0.8.20 and Jackson 2.9 transitively.
    // Keep the embedded adapter and Jackson 2 jars compatible with Jackson 3 hosts.
    jarInJar("org.msgpack:jackson-dataformat-msgpack:0.9.12")
    jarInJar("com.fasterxml.jackson.core:jackson-annotations:2.22")
    jarInJar("com.fasterxml.jackson.core:jackson-core:2.22.3")
    jarInJar("com.fasterxml.jackson.core:jackson-databind:2.22.3")
}
