import React, { useState } from "react";

function LoanCalculator() {
  const [loanAmount, setLoanAmount] = useState("");
  const [interestRate, setInterestRate] = useState("");
  const [loanTerm, setLoanTerm] = useState("");
  const [monthlyPayment, setMonthlyPayment] = useState("");

  const calculatePayment = () => {
    const principal = parseFloat(loanAmount);
    const interest = parseFloat(interestRate) / 100 / 12;
    const payments = parseFloat(loanTerm) * 12;

    const x = Math.pow(1 + interest, payments);
    const monthly = (principal * x * interest) / (x - 1);

    setMonthlyPayment(monthly.toFixed(2));
  };

  return (
    <div>
      <h2>Loan Calculator</h2>
      <form>
        <div>
          <label>Loan Amount:</label>
          <input
            type="text"
            value={loanAmount}
            onChange={(e) => setLoanAmount(e.target.value)}
          />
        </div>
        <div>
          <label>Interest Rate:</label>
          <input
            type="text"
            value={interestRate}
            onChange={(e) => setInterestRate(e.target.value)}
          />
        </div>
        <div>
          <label>Loan Term (Years):</label>
          <input
            type="text"
            value={loanTerm}
            onChange={(e) => setLoanTerm(e.target.value)}
          />
        </div>
        <button type="button" onClick={calculatePayment}>
          Calculate Payment
        </button>
      </form>
      <div>
        <label>Monthly Payment:</label>
        <span>{`$${monthlyPayment}`}</span>
      </div>
    </div>
  );
}

export default LoanCalculator;