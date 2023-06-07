package com.sbuk.shopping.dashboard;

import com.sbuk.shopping.invoice.Invoice;
import com.sbuk.shopping.invoice.InvoiceModel;

import java.util.List;

public interface DashboardService {

    DashboardCountModel countList();

    List<InvoiceModel> invoiceList();
}
