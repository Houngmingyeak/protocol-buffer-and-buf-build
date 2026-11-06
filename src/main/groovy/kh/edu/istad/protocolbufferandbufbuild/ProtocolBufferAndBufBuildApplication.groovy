package kh.edu.istad.protocolbufferandbufbuild

import kh.edu.istad.user.v1.User
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class ProtocolBufferAndBufBuildApplication {

    static void main(String[] args) {
        SpringApplication.run(ProtocolBufferAndBufBuildApplication, args)

        // សាកល្បង Protobuf
        User user = User.newBuilder()
                .setId("1")
                .setName("Mingyeak")
                .setEmail("test@example.com")
                .build()

        println "=== Protobuf test ==="
        println user

        // Serialize ទៅជា bytes រួច deserialize ត្រឡប់មកវិញ
        byte[] bytes = user.toByteArray()
        println "Serialized size: ${bytes.length} bytes"

        User parsed = User.parseFrom(bytes)
        println "Parsed name: ${parsed.name}"
    }

}