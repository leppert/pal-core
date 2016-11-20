(ns pal.core.hash-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [pal.core.hash :as hash]
            [pal.core.codecs :refer [bytes->hex]]))

(deftest pal-core-hash
  (testing "SHA2 256"
    (let [hashed (hash/sha256 "")]
      (is (= (bytes->hex hashed)
             (str "e3b0c44298fc1c149afbf4c8996fb924"
                  "27ae41e4649b934ca495991b7852b855")))))

  (testing "SHA2 384"
    (let [hashed (hash/sha384 "")]
      (is (= (bytes->hex hashed)
             (str "38b060a751ac96384cd9327eb1b1e36a"
                  "21fdb71114be07434c0cc7bf63f6e1da"
                  "274edebfe76f65fbd51ad2f14898b95b")))))

  (testing "SHA2 512"
    (let [hashed (hash/sha512 "")]
      (is (= (bytes->hex hashed)
             (str "cf83e1357eefb8bdf1542850d66d8007"
                  "d620e4050b5715dc83f4a921d36ce9ce"
                  "47d0d13c5d85f2b0ff8318d2877eec2f"
                  "63b931bd47417a81a538327af927da3e")))))

  (testing "sha1"
    (let [hashed (hash/sha1 "")]
      (is (= (bytes->hex hashed)
             "da39a3ee5e6b4b0d3255bfef95601890afd80709")))))
