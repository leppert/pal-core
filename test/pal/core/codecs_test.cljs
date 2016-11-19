(ns pal.core.codecs-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [pal.core.bytes :as bytes]
            [pal.core.codecs.base64 :as b64]
            [pal.core.codecs :refer [str->bytes
                                     bytes->str
                                     hex->bytes
                                     bytes->hex]]))

(deftest pal-core-codecs
  (testing "Hex encode/decode 01"
    (let [some-bytes  (str->bytes "FooBar")
          encoded     (bytes->hex some-bytes)
          decoded     (hex->bytes encoded)
          some-str    (bytes->str decoded)]
      (is (bytes/equals? decoded, some-bytes))
      (is (= some-str "FooBar"))))

  (testing "Hex encode/decode 02"
    (let [mybytes (into-array (range 10))
          encoded (bytes->hex mybytes)
          decoded (hex->bytes encoded)]
      (is (bytes/equals? decoded mybytes))))

  (testing "Safe base64 encode/decode"
    (let [output1 (b64/encode "foo" true)
          output2 (b64/decode output1)]
      (is (= (bytes->str output1) "Zm9v"))
      (is (= (bytes->str output2) "foo"))))

  (testing "Concat byte arrays"
    (let [array1 (into-array [1,2,3])
          array2 (into-array [3,4,5])]
      (is (bytes/equals? (bytes/concat array1 array2)
                         (into-array [1,2,3,3,4,5]))))))
