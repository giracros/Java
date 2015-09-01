<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions xmlns:tm="http://microsoft.com/wsdl/mime/textMatching/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/" xmlns:tns="http://UASI/WS_GESTESPACIOS.wsdl" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:s="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" targetNamespace="http://UASI/WS_GESTESPACIOS.wsdl" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
  <wsdl:types>
    <s:schema elementFormDefault="qualified" targetNamespace="http://UASI/WS_GESTESPACIOS.wsdl">
      <s:element name="wsedificiosuni">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="plengua" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="wsedificiosuniResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="wsedificiosuniResult" type="tns:ArrayOfClaseEdificiosUni" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfClaseEdificiosUni">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="ClaseEdificiosUni" nillable="true" type="tns:ClaseEdificiosUni" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="ClaseEdificiosUni">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="codigo" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="nombre" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="longitud" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="latitud" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="sede" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="uso" type="s:string" />
        </s:sequence>
      </s:complexType>
    </s:schema>
  </wsdl:types>
  <wsdl:message name="wsedificiosuniSoapIn">
    <wsdl:part name="parameters" element="tns:wsedificiosuni" />
  </wsdl:message>
  <wsdl:message name="wsedificiosuniSoapOut">
    <wsdl:part name="parameters" element="tns:wsedificiosuniResponse" />
  </wsdl:message>
  <wsdl:portType name="pub_gestespaciosSoap">
    <wsdl:operation name="wsedificiosuni">
      <wsdl:input message="tns:wsedificiosuniSoapIn" />
      <wsdl:output message="tns:wsedificiosuniSoapOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:binding name="pub_gestespaciosSoap" type="tns:pub_gestespaciosSoap">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="wsedificiosuni">
      <soap:operation soapAction="http://UASI/WS_GESTESPACIOS.wsdl/wsedificiosuni" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="pub_gestespaciosSoap12" type="tns:pub_gestespaciosSoap">
    <soap12:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="wsedificiosuni">
      <soap12:operation soapAction="http://UASI/WS_GESTESPACIOS.wsdl/wsedificiosuni" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:service name="pub_gestespacios">
    <wsdl:port name="pub_gestespaciosSoap" binding="tns:pub_gestespaciosSoap">
      <soap:address location="https://cvnet.cpd.ua.es/servicioweb/publicos/pub_gestespacios.asmx" />
    </wsdl:port>
    <wsdl:port name="pub_gestespaciosSoap12" binding="tns:pub_gestespaciosSoap12">
      <soap12:address location="https://cvnet.cpd.ua.es/servicioweb/publicos/pub_gestespacios.asmx" />
    </wsdl:port>
  </wsdl:service>
</wsdl:definitions>