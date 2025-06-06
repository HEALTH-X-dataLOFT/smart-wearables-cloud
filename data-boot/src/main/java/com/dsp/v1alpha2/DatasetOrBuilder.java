// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: dsp/v1alpha2/types.proto

// Protobuf Java Version: 3.25.3
package com.dsp.v1alpha2;

public interface DatasetOrBuilder extends
    // @@protoc_insertion_point(interface_extends:dsp.v1alpha2.Dataset)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string id = 1 [json_name = "id"];</code>
   * @return The id.
   */
  String getId();
  /**
   * <code>string id = 1 [json_name = "id"];</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>string title = 2 [json_name = "title"];</code>
   * @return The title.
   */
  String getTitle();
  /**
   * <code>string title = 2 [json_name = "title"];</code>
   * @return The bytes for title.
   */
  com.google.protobuf.ByteString
      getTitleBytes();

  /**
   * <code>string access_methods = 3 [json_name = "accessMethods"];</code>
   * @return The accessMethods.
   */
  String getAccessMethods();
  /**
   * <code>string access_methods = 3 [json_name = "accessMethods"];</code>
   * @return The bytes for accessMethods.
   */
  com.google.protobuf.ByteString
      getAccessMethodsBytes();

  /**
   * <code>repeated .dsp.v1alpha2.Multilingual description = 4 [json_name = "description"];</code>
   */
  java.util.List<Multilingual>
      getDescriptionList();
  /**
   * <code>repeated .dsp.v1alpha2.Multilingual description = 4 [json_name = "description"];</code>
   */
  Multilingual getDescription(int index);
  /**
   * <code>repeated .dsp.v1alpha2.Multilingual description = 4 [json_name = "description"];</code>
   */
  int getDescriptionCount();
  /**
   * <code>repeated .dsp.v1alpha2.Multilingual description = 4 [json_name = "description"];</code>
   */
  java.util.List<? extends MultilingualOrBuilder>
      getDescriptionOrBuilderList();
  /**
   * <code>repeated .dsp.v1alpha2.Multilingual description = 4 [json_name = "description"];</code>
   */
  MultilingualOrBuilder getDescriptionOrBuilder(
      int index);

  /**
   * <code>repeated string keywords = 5 [json_name = "keywords"];</code>
   * @return A list containing the keywords.
   */
  java.util.List<String>
      getKeywordsList();
  /**
   * <code>repeated string keywords = 5 [json_name = "keywords"];</code>
   * @return The count of keywords.
   */
  int getKeywordsCount();
  /**
   * <code>repeated string keywords = 5 [json_name = "keywords"];</code>
   * @param index The index of the element to return.
   * @return The keywords at the given index.
   */
  String getKeywords(int index);
  /**
   * <code>repeated string keywords = 5 [json_name = "keywords"];</code>
   * @param index The index of the value to return.
   * @return The bytes of the keywords at the given index.
   */
  com.google.protobuf.ByteString
      getKeywordsBytes(int index);

  /**
   * <code>optional string creator = 6 [json_name = "creator"];</code>
   * @return Whether the creator field is set.
   */
  boolean hasCreator();
  /**
   * <code>optional string creator = 6 [json_name = "creator"];</code>
   * @return The creator.
   */
  String getCreator();
  /**
   * <code>optional string creator = 6 [json_name = "creator"];</code>
   * @return The bytes for creator.
   */
  com.google.protobuf.ByteString
      getCreatorBytes();

  /**
   * <code>optional .google.protobuf.Timestamp issued = 7 [json_name = "issued"];</code>
   * @return Whether the issued field is set.
   */
  boolean hasIssued();
  /**
   * <code>optional .google.protobuf.Timestamp issued = 7 [json_name = "issued"];</code>
   * @return The issued.
   */
  com.google.protobuf.Timestamp getIssued();
  /**
   * <code>optional .google.protobuf.Timestamp issued = 7 [json_name = "issued"];</code>
   */
  com.google.protobuf.TimestampOrBuilder getIssuedOrBuilder();

  /**
   * <code>optional .google.protobuf.Timestamp modified = 8 [json_name = "modified"];</code>
   * @return Whether the modified field is set.
   */
  boolean hasModified();
  /**
   * <code>optional .google.protobuf.Timestamp modified = 8 [json_name = "modified"];</code>
   * @return The modified.
   */
  com.google.protobuf.Timestamp getModified();
  /**
   * <code>optional .google.protobuf.Timestamp modified = 8 [json_name = "modified"];</code>
   */
  com.google.protobuf.TimestampOrBuilder getModifiedOrBuilder();

  /**
   * <code>map&lt;string, string&gt; metadata = 9 [json_name = "metadata"];</code>
   */
  int getMetadataCount();
  /**
   * <code>map&lt;string, string&gt; metadata = 9 [json_name = "metadata"];</code>
   */
  boolean containsMetadata(
      String key);
  /**
   * Use {@link #getMetadataMap()} instead.
   */
  @Deprecated
  java.util.Map<String, String>
  getMetadata();
  /**
   * <code>map&lt;string, string&gt; metadata = 9 [json_name = "metadata"];</code>
   */
  java.util.Map<String, String>
  getMetadataMap();
  /**
   * <code>map&lt;string, string&gt; metadata = 9 [json_name = "metadata"];</code>
   */
  /* nullable */
String getMetadataOrDefault(
      String key,
      /* nullable */
String defaultValue);
  /**
   * <code>map&lt;string, string&gt; metadata = 9 [json_name = "metadata"];</code>
   */
  String getMetadataOrThrow(
      String key);

  /**
   * <code>optional string license = 10 [json_name = "license"];</code>
   * @return Whether the license field is set.
   */
  boolean hasLicense();
  /**
   * <code>optional string license = 10 [json_name = "license"];</code>
   * @return The license.
   */
  String getLicense();
  /**
   * <code>optional string license = 10 [json_name = "license"];</code>
   * @return The bytes for license.
   */
  com.google.protobuf.ByteString
      getLicenseBytes();

  /**
   * <code>optional string access_rights = 11 [json_name = "accessRights"];</code>
   * @return Whether the accessRights field is set.
   */
  boolean hasAccessRights();
  /**
   * <code>optional string access_rights = 11 [json_name = "accessRights"];</code>
   * @return The accessRights.
   */
  String getAccessRights();
  /**
   * <code>optional string access_rights = 11 [json_name = "accessRights"];</code>
   * @return The bytes for accessRights.
   */
  com.google.protobuf.ByteString
      getAccessRightsBytes();

  /**
   * <code>optional string rights = 12 [json_name = "rights"];</code>
   * @return Whether the rights field is set.
   */
  boolean hasRights();
  /**
   * <code>optional string rights = 12 [json_name = "rights"];</code>
   * @return The rights.
   */
  String getRights();
  /**
   * <code>optional string rights = 12 [json_name = "rights"];</code>
   * @return The bytes for rights.
   */
  com.google.protobuf.ByteString
      getRightsBytes();

  /**
   * <code>int64 byte_size = 13 [json_name = "byteSize"];</code>
   * @return The byteSize.
   */
  long getByteSize();

  /**
   * <code>string media_type = 14 [json_name = "mediaType"];</code>
   * @return The mediaType.
   */
  String getMediaType();
  /**
   * <code>string media_type = 14 [json_name = "mediaType"];</code>
   * @return The bytes for mediaType.
   */
  com.google.protobuf.ByteString
      getMediaTypeBytes();

  /**
   * <code>optional string format = 15 [json_name = "format"];</code>
   * @return Whether the format field is set.
   */
  boolean hasFormat();
  /**
   * <code>optional string format = 15 [json_name = "format"];</code>
   * @return The format.
   */
  String getFormat();
  /**
   * <code>optional string format = 15 [json_name = "format"];</code>
   * @return The bytes for format.
   */
  com.google.protobuf.ByteString
      getFormatBytes();

  /**
   * <code>optional string compress_format = 16 [json_name = "compressFormat"];</code>
   * @return Whether the compressFormat field is set.
   */
  boolean hasCompressFormat();
  /**
   * <code>optional string compress_format = 16 [json_name = "compressFormat"];</code>
   * @return The compressFormat.
   */
  String getCompressFormat();
  /**
   * <code>optional string compress_format = 16 [json_name = "compressFormat"];</code>
   * @return The bytes for compressFormat.
   */
  com.google.protobuf.ByteString
      getCompressFormatBytes();

  /**
   * <code>optional string package_format = 17 [json_name = "packageFormat"];</code>
   * @return Whether the packageFormat field is set.
   */
  boolean hasPackageFormat();
  /**
   * <code>optional string package_format = 17 [json_name = "packageFormat"];</code>
   * @return The packageFormat.
   */
  String getPackageFormat();
  /**
   * <code>optional string package_format = 17 [json_name = "packageFormat"];</code>
   * @return The bytes for packageFormat.
   */
  com.google.protobuf.ByteString
      getPackageFormatBytes();

  /**
   * <code>optional .dsp.v1alpha2.Checksum checksum = 18 [json_name = "checksum"];</code>
   * @return Whether the checksum field is set.
   */
  boolean hasChecksum();
  /**
   * <code>optional .dsp.v1alpha2.Checksum checksum = 18 [json_name = "checksum"];</code>
   * @return The checksum.
   */
  Checksum getChecksum();
  /**
   * <code>optional .dsp.v1alpha2.Checksum checksum = 18 [json_name = "checksum"];</code>
   */
  ChecksumOrBuilder getChecksumOrBuilder();
}
